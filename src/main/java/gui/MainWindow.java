package gui;

import gui.configuration.Language;
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
    private final MenuBar menuBar = new MenuBar();

    private final VBox root = new VBox();

    @Override
    public void start(Stage stage) {
        initMenuBar();
        root.setFillWidth(true);
        Tab firstTab = new Tab("note" + tabsCount++);
        firstTab.setContent(new GraphWindow());
        Tab secondTab = new Tab("note" + tabsCount++);
        secondTab.setContent(new GraphWindow());
        tabPane.getTabs().addAll(firstTab, secondTab);
        root.getChildren().addAll(menuBar, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("mainwindow/default.css");
        stage.setScene(scene);
        stage.show();
    }

    private void initMenuBar() {
        Menu file = initMenuBarFileMenu();
        Menu settings = initMenuBarSettingsMenu();
        Menu help = initMenuBarHelpMenu();
        menuBar.getMenus().addAll(file, settings, help);
        System.out.println(file.getStyleClass());
        System.out.println(menuBar.getStyleClass());
//        menuBar.getStyleClass().add("menuBar");
    }

    private Menu initMenuBarFileMenu() {
        Menu file = new Menu(Language.fileMenu);
        MenuItem newTreeNote = new MenuItem(Language.newMenuItem);
        MenuItem loadTreeNote = new MenuItem(Language.loadMenuItem);
        MenuItem saveTreeNote = new MenuItem(Language.saveMenuItem);
        MenuItem saveAllTreeNote = new MenuItem(Language.saveAllMenuItem);
        MenuItem closeTreeNote = new MenuItem(Language.closeMenuItem);
        MenuItem closeAllTreeNote = new MenuItem(Language.closeAllMenuItem);
        file.getItems().addAll(newTreeNote, loadTreeNote, new SeparatorMenuItem(), saveTreeNote, saveAllTreeNote, new SeparatorMenuItem(), closeTreeNote, closeAllTreeNote);
        return file;
    }

    private Menu initMenuBarSettingsMenu() {
        Menu settings = new Menu(Language.settingsMenu);
        MenuItem main = new MenuItem(Language.mainMenuItem);
        MenuItem theme = new MenuItem(Language.themeMenuItem);
        MenuItem language = new MenuItem(Language.languageMenuItem);
        settings.getItems().addAll(main, theme, language);
        return settings;
    }

    private Menu initMenuBarHelpMenu() {
        Menu help = new Menu(Language.helpMenu);
//        help.getStyleClass().add("menu");
        MenuItem tutorial = new MenuItem(Language.tutorialMenuItem);
//        tutorial.getStyleClass().add("menuItem");
        MenuItem statistics = new MenuItem(Language.statisticsMenuItem);
//        statistics.getStyleClass().add("menuItem");
        MenuItem about = new MenuItem(Language.aboutMenuItem);
//        about.getStyleClass().add("menuItem");
        help.getItems().addAll(tutorial, statistics, about);
        return help;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
