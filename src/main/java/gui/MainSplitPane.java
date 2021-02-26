package gui;

import gui.graphwindow.GraphWindow;
import gui.toolspane.ToolsPane;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.logging.Logger;


public class MainSplitPane extends SplitPane {

    private static int tabsCount = 0;
    private final TabPane tabPane = new TabPane();
    private final ToolsPane toolsPane = new ToolsPane();

    public MainSplitPane() {
        VBox.setVgrow(this, Priority.ALWAYS);
        this.getItems().addAll(tabPane, toolsPane);

        init();
    }

    private void init(){

        Tab firstTab = new Tab("note" + tabsCount++);
        firstTab.setContent(new GraphWindow());
        Tab secondTab = new Tab("note" + tabsCount++);
        secondTab.setContent(new GraphWindow());
        tabPane.getTabs().addAll(firstTab, secondTab);
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}
