package gui;

import gui.graphwindow.GraphWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application {
    private static int tabsCount = 0;
    private static final double WINDOW_HEIGHT = Screen.getPrimary().getBounds().getHeight() * 0.8;
    private static final double WINDOW_WIDTH = Screen.getPrimary().getBounds().getWidth() * 0.8;

    private final TabPane tabPane = new TabPane();
    private final MainWindowMenuBar menuBar = new MainWindowMenuBar();

    private final VBox root = new VBox();

    @Override
    public void start(Stage stage) {
        root.setFillWidth(true);
        Tab firstTab = new Tab("note" + tabsCount++);
        firstTab.setContent(new GraphWindow());
        Tab secondTab = new Tab("note" + tabsCount++);
        secondTab.setContent(new GraphWindow());
        tabPane.getTabs().addAll(firstTab, secondTab);
        root.getChildren().addAll(menuBar, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("styles/mainwindowdefault.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
