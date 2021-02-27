package gui.toolspane;

import gui.MainSplitPane;
import gui.configuration.Language;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class MainSideBar extends VBox {
    private int currentPane = 0;
    private final Button openToolPane = new Button();

    public MainSideBar() {
        this.setStyle("\n" +
                " -fx-background-color: #424241;" +
                " -fx-border-color: transparent transparent transparent orange;");
        initButtons();
        addButtons();
    }

    private void addButtons() {
        this.getChildren().addAll(openToolPane);
    }

    private void initButtons() {
        initOpenToolsButton();
    }

    private void initOpenToolsButton() {
        Label text = new Label(Language.sideBarToolsButtonText);
        text.setRotate(90);
        openToolPane.setGraphic(new Group(text));

        openToolPane.setPrefWidth(20);
        openToolPane.setOnMouseClicked(event -> {
            if (currentPane == 1){
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(null);
                currentPane = 0;
            }
            else{
                ((MainSplitPane) ((BorderPane) getParent()).getCenter()).setPane(new ToolsPane());
                currentPane = 1;
            }
        });
    }
}
