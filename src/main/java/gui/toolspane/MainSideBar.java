package gui.toolspane;

import gui.MainSplitPane;
import gui.configuration.Language;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class MainSideBar extends VBox {
    enum Panes {NonePane, ToolsPane, GraphInformationPane}

    private Panes currentPane = Panes.NonePane;
    private final Button openToolPane = new Button();
    private final Button openGraphInformationPane = new Button();

    public MainSideBar() {
        this.setStyle("\n" +
                " -fx-background-color: #424241;" +
                " -fx-border-color: transparent transparent transparent orange;");
        initButtons();
        addButtons();
    }

    private void addButtons() {
        this.getChildren().add(openToolPane);
        this.getChildren().add(openGraphInformationPane);
    }

    private void initButtons() {
        initOpenToolsButton();
        initOpenGraphInformationButton();
    }

    private void initOpenToolsButton() {
        Label text = new Label(Language.sideBarToolsButtonText);
        text.setRotate(90);
        openToolPane.setGraphic(new Group(text));
        openToolPane.setOnMouseClicked(event -> {
            if (currentPane == Panes.ToolsPane) {
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(null);
                currentPane = Panes.NonePane;
            } else {
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(new ToolsPane());
                currentPane = Panes.ToolsPane;
            }
        });
    }

    private void initOpenGraphInformationButton() {
        Label text = new Label(Language.sideBarGraphInformationButtonText);
        text.setRotate(90);
        openGraphInformationPane.setGraphic(new Group(text));
        openGraphInformationPane.setOnMouseClicked(event -> {
            if (currentPane == Panes.GraphInformationPane) {
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(null);
                currentPane = Panes.NonePane;
            } else {
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(new GraphInformationPane());
                currentPane = Panes.GraphInformationPane;
            }
        });
    }
}
