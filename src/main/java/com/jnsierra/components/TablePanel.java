package com.jnsierra.components;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.*;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.BooleanTableCellRenderer;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class TablePanel extends JPanel {

    private final JBTable jbTable;
    private final String[] columnNames = {"Campo", "Tipo de dato (Java)", "Tipo de dato (Sql)", "Nullable", "Primary Key"};
    private final Object[][] data = {};
    private final DefaultTableModel model;

    public TablePanel(){
        this.model = new DefaultTableModel(data, columnNames);
        this.jbTable = new JBTable(model);
        initTable();
        initToolbar();
    }

    public void initTable(){
        setLayout(new BorderLayout());
        //JPanel toolbarPanel = toolBar.createPanel();
        JBScrollPane scrollPane = new JBScrollPane(jbTable);
        add(scrollPane, BorderLayout.CENTER);
    }
    public void initToolbar(){
        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(this.jbTable)
                .setAddAction(anActionButton -> addRow())
                .setRemoveAction(anActionButton -> deleteRow());

        decorator.addExtraAction(new Separator() );

        decorator.addExtraAction(new AnActionButton("Generar Liquidbase", AllIcons.Providers.Liquibase) {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                // Acción del tercer botón
                JOptionPane.showMessageDialog(null, "Otro botón presionado");
            }
        });

        decorator.setToolbarPosition(ActionToolbarPosition.RIGHT);

        add(decorator.createPanel());

    }

    public void addRow() {
        String[] comboJavaTypes = DataTypeField.getJavaTypes().toArray(new String[0]);
        JComboBox<String> comboBox = new JComboBox<>(comboJavaTypes);
        TableColumn comboBoxColumn = jbTable.getColumnModel().getColumn(1);
        comboBoxColumn.setCellEditor(new DefaultCellEditor(comboBox));

        // Checkbox Nullable
        TableColumn columnNull = jbTable.getColumnModel().getColumn(3);
        columnNull.setCellEditor(JBTable.createBooleanEditor());
        columnNull.setCellRenderer(new BooleanTableCellRenderer());

        // Checkbox Primary Key
        TableColumn column = jbTable.getColumnModel().getColumn(4);
        column.setCellEditor(JBTable.createBooleanEditor());
        column.setCellRenderer(new BooleanTableCellRenderer());

        model.addRow(new Object[]{"", "String", "varchar", false, false});
    }

    // Método para eliminar filas de la tabla
    public void deleteRow() {
        int selectedRow = jbTable.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }

}