package com.jnsierra.components;

import javax.swing.*;
import java.awt.*;

public class PanelManageTable {

    private final JPanel mainPanel;

    public PanelManageTable() {
        this.mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add row");
        JButton deleteButton = new JButton("Add row");

        mainPanel.add(addButton);
        mainPanel.add(deleteButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
