package com.jnsierra.components;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableDataInformation {

    private final JBTable table;
    private final String[] columnNames = {"Campo", "Tipo de dato (Java)", "Tipo de dato (Sql)", "Nullable", "Primary Key"};
    private final Object[][] data = {};
    private final JPanel mainPanel;

    public TableDataInformation() {
        mainPanel = new JPanel(new BorderLayout());
        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JBTable(model);
        JBScrollPane scrollPane = new JBScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanelTable(){
        return this.mainPanel;
    }

}
