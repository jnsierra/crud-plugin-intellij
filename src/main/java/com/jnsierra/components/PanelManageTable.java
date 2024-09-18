package com.jnsierra.components;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelManageTable {

    private final JPanel mainPanel;
    private final TableDataInformation tableDataInformation;

    public PanelManageTable(TableDataInformation tableDataInformation) {
        this.tableDataInformation = tableDataInformation;
        this.mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add row");
        JButton deleteButton = new JButton("Delete row");

        addButton.addActionListener(addRowTable());

        mainPanel.add(addButton);
        mainPanel.add(deleteButton);
    }

    private @NotNull ActionListener addRowTable() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableDataInformation.addRow();
            }
        };
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
