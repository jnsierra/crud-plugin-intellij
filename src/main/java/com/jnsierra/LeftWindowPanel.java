package com.jnsierra;

import com.intellij.openapi.wm.ToolWindow;
import com.jnsierra.components.PanelManageTable;
import com.jnsierra.components.TableDataInformation;
import com.jnsierra.components.TablePanel;

import javax.swing.*;
import java.awt.*;

public class LeftWindowPanel {
    private final ToolWindow toolWindow;
    private final JPanel mainPanel;
    private final PrincipalToolWindowFactory principalToolWindowFactory;

    public LeftWindowPanel(ToolWindow toolWindow, PrincipalToolWindowFactory principalToolWindowFactory ) {
        this.principalToolWindowFactory = principalToolWindowFactory;
        //TableDataInformation tableDataInformation = new TableDataInformation();
        TablePanel tablePanel = new TablePanel();
        //PanelManageTable panelManageTable = new PanelManageTable(tableDataInformation, principalToolWindowFactory);
        this.toolWindow = toolWindow;
        this.mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField inputField = new JTextField(20);
        JLabel label = new JLabel("Nombre Tabla:");

        topPanel.add(label);
        topPanel.add(inputField);


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        //mainPanel.add(panelManageTable.getMainPanel(), BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
