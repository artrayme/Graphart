package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application {
    public static final double WINDOW_HEIGHT = Screen.getPrimary().getBounds().getHeight() * 0.8;
    public static final double WINDOW_WIDTH = Screen.getPrimary().getBounds().getWidth() * 0.8;

    private final MainSplitPane mainSplitPane = new MainSplitPane();
    private final MainMenuBar menuBar = new MainMenuBar();

    private final VBox root = new VBox();

    @Override
    public void start(Stage stage) {
        root.setFillWidth(true);
        root.getChildren().addAll(menuBar, mainSplitPane);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("styles/mainwindowdefault.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

