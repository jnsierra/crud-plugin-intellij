package com.jnsierra.components;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableDataInformation {

    private final JBTable table;
    private final String[] columnNames = {"Campo", "Tipo de dato (Java)", "Tipo de dato (Sql)", "Nullable", "Primary Key"};
    private final Object[][] data = {};
    private final JPanel mainPanel;
    private final DefaultTableModel model;

    public TableDataInformation() {
        mainPanel = new JPanel(new BorderLayout());
        this.model = new DefaultTableModel(data, columnNames);
        this.model.addTableModelListener(changeModelTable());
        table = new JBTable(model);
        JBScrollPane scrollPane = new JBScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanelTable(){
        return this.mainPanel;
    }

    public void addRow(){
        String[] comboJavaTypes = DataTypeField.getJavaTypes().toArray(new String[0]);
        JComboBox<String> comboBox = new JComboBox<>(comboJavaTypes);
        TableColumn comboBoxColumn = table.getColumnModel().getColumn(1);
        comboBoxColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //Checkbox Nullable
        JBCheckBox checkBoxNull = new JBCheckBox();
        TableColumn comboBoxColumnCheck = table.getColumnModel().getColumn(3);
        comboBoxColumnCheck.setCellEditor(new DefaultCellEditor(checkBoxNull));
        //Checkbox Primary Key
        JBCheckBox checkBoxPK = new JBCheckBox();
        TableColumn comboBoxColumnPK = table.getColumnModel().getColumn(4);
        comboBoxColumnPK.setCellEditor(new DefaultCellEditor(checkBoxPK));

        //Seteo los valores iniciales
        model.addRow(new Object[]{"", "String", "varchar",false, false});

    }

    private @NotNull TableModelListener changeModelTable() {
        return new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 1) {
                        String selectedValue = (String) model.getValueAt(row, column);
                        //Seteamos el valor en la columna de sql
                        model.setValueAt(DataTypeField.getEnumByJavaDataType(selectedValue).getLiquidbase(), row, column +1);
                    }
                }

            }
        };
    }

}
