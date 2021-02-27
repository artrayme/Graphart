package gui;

import gui.graphwindow.GraphWindow;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class MainSplitPane extends SplitPane {

    private static int tabsCount = 0;
    private final TabPane tabPane = new TabPane();
    private Pane advancedPane;

    public MainSplitPane() {
        init();
        VBox.setVgrow(this, Priority.ALWAYS);
        this.getItems().addAll(tabPane);
    }

    private void init() {
        Tab firstTab = new Tab("note" + tabsCount++);
        firstTab.setContent(new GraphWindow());
        Tab secondTab = new Tab("note" + tabsCount++);
        secondTab.setContent(new GraphWindow());
        tabPane.getTabs().addAll(firstTab, secondTab);
    }

    public TabPane getTabPane() {
        return tabPane;
    }

    public void setPane(Pane pane) {
        if (advancedPane != null) {
            this.getItems().remove(advancedPane);
        }
        if (pane != null) {
            advancedPane = pane;
            this.getItems().add(advancedPane);
        }
    }

}
