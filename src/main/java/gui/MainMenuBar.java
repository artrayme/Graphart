package gui;

import gui.configuration.Language;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainMenuBar extends MenuBar {

    public MainMenuBar() {
        initMenuBar();
    }

    private void initMenuBar() {
        Menu file = initMenuBarFileMenu();
        Menu settings = initMenuBarSettingsMenu();
        Menu help = initMenuBarHelpMenu();
        this.getMenus().addAll(file, settings, help);
    }

    private Menu initMenuBarFileMenu() {
        Menu file = new Menu(Language.fileMenu);
        MenuItem newTreeNote = initNewMenuItem();
        MenuItem loadTreeNote = initLoadMenuItem();
        MenuItem saveTreeNote = initSaveMenuItem();
        MenuItem saveAllTreeNote = initSaveAllMenuItem();
        MenuItem closeTreeNote = initCloseMenuItem();
        MenuItem closeAllTreeNote = initCloseAllMenuItem();
        file.getItems().addAll(newTreeNote, loadTreeNote, new SeparatorMenuItem(), saveTreeNote, saveAllTreeNote, new SeparatorMenuItem(), closeTreeNote, closeAllTreeNote);
        return file;
    }

    private MenuItem initNewMenuItem() {
        MenuItem newTreeNote = new MenuItem(Language.newMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/new.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        newTreeNote.setGraphic(view);
        return newTreeNote;
    }

    private MenuItem initLoadMenuItem() {
        MenuItem loadTreeNote = new MenuItem(Language.loadMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/load.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        loadTreeNote.setGraphic(view);
        return loadTreeNote;
    }

    private MenuItem initSaveMenuItem() {
        MenuItem saveTreeNote = new MenuItem(Language.saveMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/save.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        saveTreeNote.setGraphic(view);
        return saveTreeNote;
    }

    private MenuItem initSaveAllMenuItem() {
        MenuItem saveAllTreeNote = new MenuItem(Language.saveAllMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/saveall.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        saveAllTreeNote.setGraphic(view);
        return saveAllTreeNote;
    }

    private MenuItem initCloseMenuItem() {
        MenuItem closeTreeNote = new MenuItem(Language.closeMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/close.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        closeTreeNote.setGraphic(view);
        return closeTreeNote;
    }

    private MenuItem initCloseAllMenuItem() {
        MenuItem closeAllTreeNote = new MenuItem(Language.closeMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/filemenu/closeall.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        closeAllTreeNote.setGraphic(view);
        return closeAllTreeNote;
    }

    private Menu initMenuBarSettingsMenu() {
        Menu settings = new Menu(Language.settingsMenu);
        MenuItem main = initMainMenuItem();
        MenuItem theme = initThemeMenuItem();
        MenuItem language = initLanguageMenuItem();
        settings.getItems().addAll(main, theme, language);
        return settings;
    }

    private MenuItem initMainMenuItem() {
        MenuItem main = new MenuItem(Language.mainMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/settingsmenu/settings.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        main.setGraphic(view);
        return main;
    }

    private MenuItem initThemeMenuItem() {
        MenuItem theme = new MenuItem(Language.themeMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/settingsmenu/theme.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        theme.setGraphic(view);
        return theme;
    }

    private MenuItem initLanguageMenuItem() {
        MenuItem language = new MenuItem(Language.languageMenuItem);
        Image icon = new Image(getClass().getResourceAsStream("/icons/settingsmenu/language.png"));
        ImageView view = new ImageView(icon);
        view.setFitWidth(24);
        view.setFitHeight(24);
        language.setGraphic(view);
        return language;
    }

    private Menu initMenuBarHelpMenu() {
        Menu help = new Menu(Language.helpMenu);
        MenuItem tutorial = new MenuItem(Language.tutorialMenuItem);
        MenuItem statistics = new MenuItem(Language.statisticsMenuItem);
        MenuItem about = new MenuItem(Language.aboutMenuItem);
        help.getItems().addAll(tutorial, statistics, about);
        return help;
    }

}
