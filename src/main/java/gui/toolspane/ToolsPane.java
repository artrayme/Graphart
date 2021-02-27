package gui.toolspane;

import gui.MainSplitPane;
import gui.MainWindow;
import gui.configuration.Language;
import gui.graphwindow.GraphWindow;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class ToolsPane extends GridPane {
    public final double buttonsSize = MainWindow.WINDOW_WIDTH/12;
    private final Button newNodeButton = new Button(Language.newNodeButtonText);
    private final Button newArcButton = new Button(Language.newArcButtonText);
    private final Button newEdgeButton = new Button(Language.newEdgeButtonText);
    private final Button addTextButton = new Button(Language.addTextButton);
    private final Button deleteButton = new Button(Language.deleteButtonText);

    public ToolsPane() {
        initButtons();
        addButtonsToPane();
    }

    private void initButtons() {
        initNewNodeButton();
        initNewArcButton();
        initNewEdgeButton();
        initAddTextButton();
        initDeleteButton();
    }

    private void addButtonsToPane() {
        setMaxWidth(MainWindow.WINDOW_WIDTH/5);
        setMinWidth(MainWindow.WINDOW_WIDTH/6);

        this.add(newNodeButton, 0,0);
        this.add(deleteButton, 1,0);
        this.add(newArcButton, 0, 1);
        this.add(newEdgeButton, 1, 1);
    }

    private void initNewNodeButton() {
        setButtonSizesInGrid(newNodeButton);
        newNodeButton.setOnMouseClicked(event -> {
            MainSplitPane mainSplitPane = (MainSplitPane) (getParent().getParent());
            ((GraphWindow) (mainSplitPane.getTabPane().getSelectionModel().getSelectedItem().getContent())).addNewNode();
        });

    }

    private void initNewArcButton() {
        setButtonSizesInGrid(newArcButton);
        newArcButton.setOnMouseClicked(event -> {
            MainSplitPane mainSplitPane = (MainSplitPane) (getParent().getParent());
            ((GraphWindow) (mainSplitPane.getTabPane().getSelectionModel().getSelectedItem().getContent())).connectNodesWithArcs();
        });
    }

    private void initNewEdgeButton() {
        setButtonSizesInGrid(newEdgeButton);

        newEdgeButton.setOnMouseClicked(event -> {
            MainSplitPane mainSplitPane = (MainSplitPane) (getParent().getParent());
            ((GraphWindow) (mainSplitPane.getTabPane().getSelectionModel().getSelectedItem().getContent())).connectNodesWithEdges();
        });
    }

    private void initAddTextButton() {
        setButtonSizesInGrid(addTextButton);

        addTextButton.setOnMouseClicked(event -> {
            MainSplitPane mainSplitPane = (MainSplitPane) (getParent().getParent());
            ((GraphWindow) (mainSplitPane.getTabPane().getSelectionModel().getSelectedItem().getContent())).addTextForSelectedElement();
        });
    }

    private void initDeleteButton() {
        setButtonSizesInGrid(deleteButton);
        deleteButton.setOnMouseClicked(event -> {
            MainSplitPane mainSplitPane = (MainSplitPane) (getParent().getParent());
            ((GraphWindow) (mainSplitPane.getTabPane().getSelectionModel().getSelectedItem().getContent())).deleteSelectedNodes();
        });
    }

    private void setButtonSizesInGrid(Button button){
        button.setPrefWidth(buttonsSize);
        button.setPrefHeight(buttonsSize);
        GridPane.setMargin(button, new Insets(10));

    }
}
