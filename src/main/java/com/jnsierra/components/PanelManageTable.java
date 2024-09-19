package com.jnsierra.components;

import com.jnsierra.PrincipalToolWindowFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelManageTable {

    private final JPanel mainPanel;
    private final TableDataInformation tableDataInformation;
    private final PrincipalToolWindowFactory principalToolWindowFactory;

    public PanelManageTable(TableDataInformation tableDataInformation, PrincipalToolWindowFactory principalToolWindowFactory) {
        this.principalToolWindowFactory = principalToolWindowFactory;
        this.tableDataInformation = tableDataInformation;
        this.mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add row");
        JButton deleteButton = new JButton("Delete row");
        JButton executeAction = new JButton("Generate Liquidbase");

        addButton.addActionListener(addRowTable());
        deleteButton.addActionListener(deleteRowTable());
        executeAction.addActionListener(executeLiquidbase());

        mainPanel.add(addButton);
        mainPanel.add(deleteButton);
        mainPanel.add(executeAction);
    }

    private @NotNull ActionListener addRowTable() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableDataInformation.addRow();
            }
        };
    }

    private @NotNull ActionListener deleteRowTable(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableDataInformation.deleteRow();
            }
        };
    }

    private @NotNull ActionListener executeLiquidbase(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalToolWindowFactory.executeActionListener();

            }
        };

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
