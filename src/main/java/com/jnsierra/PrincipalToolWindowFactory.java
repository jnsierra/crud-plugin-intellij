package com.jnsierra;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBSplitter;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class PrincipalToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        LeftWindowPanel leftWindowPanel = new LeftWindowPanel(toolWindow, this);

        JBSplitter splitPanel = new JBSplitter(false, 0.5f);
        splitPanel.setFirstComponent(leftWindowPanel.getMainPanel());

        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(splitPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    public void executeActionListener(){
        System.out.println("Genero Liquidbase");
    }
}
