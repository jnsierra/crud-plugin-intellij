package com.jnsierra;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBLabel;
import com.jnsierra.components.TablePanel;
import com.jnsierra.dto.FieldDTO;
import com.jnsierra.logic.liquidbase.LiquidBasePrincipal;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class LeftWindowPanel {
    private final ToolWindow toolWindow;
    private final JPanel mainPanel;
    private final PrincipalToolWindowFactory principalToolWindowFactory;

    public LeftWindowPanel(ToolWindow toolWindow, PrincipalToolWindowFactory principalToolWindowFactory) {
        this.principalToolWindowFactory = principalToolWindowFactory;
        TablePanel tablePanel = new TablePanel();
        this.toolWindow = toolWindow;
        this.mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField tableNameField = new JTextField(20);
        JLabel label = new JLabel("Nombre Tabla:");
        JLabel labelFile = new JLabel("Carpeta destino LiquidBase:");
        JButton buttonExec = new JButton("Ejecutar");

        Project project = ProjectManager.getInstance().getOpenProjects()[0];
        // Configurar el FileChooserDescriptor para permitir seleccionar solo directorios
        FileChooserDescriptor descriptor = getFileChooserDescriptor(project);

        TextFieldWithBrowseButton textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        textFieldWithBrowseButton.addBrowseFolderListener("Seleccione carpeta", "Seleccione una carpeta dentro de resources", project,
                descriptor
        );

        buttonExec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = tableNameField.getText();
                if ("".equals(tableName)) {
                    Messages.showErrorDialog("El nombre de la tabla no puede ser nulo", "Nombre Tabla Requerido");
                    return ;
                }
                String pathLiquidbase = textFieldWithBrowseButton.getText();
                if (pathLiquidbase.equals("")) {
                    Messages.showErrorDialog("Carpeta destino liquidbase no puede ser nula", "Path Liquidbase");
                    return ;
                }

                Optional<List<FieldDTO>> tableData = tablePanel.getDataTable();
                if(tableData.isEmpty()){
                    return ;
                }

                LiquidBasePrincipal liquidBasePrincipal = new LiquidBasePrincipal(tableName, pathLiquidbase, tableData.get());
                System.out.println("Ejecutamos la actividad");
            }
        });


        topPanel.add(label);
        topPanel.add(tableNameField);
        topPanel.add(labelFile);
        topPanel.add(textFieldWithBrowseButton);
        topPanel.add(buttonExec);


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }

    private static @NotNull FileChooserDescriptor getFileChooserDescriptor(Project project) {
        // Obtener la ruta absoluta de la carpeta "resources" dentro del proyecto
        VirtualFile resourcesDirectory = ProjectRootManager.getInstance(project)
                .getContentRoots()[0]
                .findChild("src")
                .findChild("main")
                .findChild("resources");

        FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false) {
            @Override
            public boolean isFileSelectable(VirtualFile file) {
                // Permitir la selección solo dentro de la carpeta "resources"
                return file != null && VfsUtilCore.isAncestor(resourcesDirectory, file, false);
            }
        };
        return descriptor;
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
