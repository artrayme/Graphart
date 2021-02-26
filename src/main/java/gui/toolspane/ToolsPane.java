package gui.toolspane;

import gui.MainSplitPane;
import gui.MainWindow;
import gui.configuration.Language;
import gui.graphwindow.GraphWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class ToolsPane extends GridPane {
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
//        HBox.setHgrow(this, Priority.ALWAYS);
//        VBox.setVgrow(this, Priority.ALWAYS);
//        this.setPrefWidth(Double.MAX_VALUE);

        ColumnConstraints column = new ColumnConstraints(150, 150, Double.MAX_VALUE);
//        column.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(column);

        RowConstraints row = new RowConstraints(150, 150, Double.MAX_VALUE);
//        row.setVgrow(Priority.ALWAYS);
        getRowConstraints().add(row);

        setMaxWidth(MainWindow.WINDOW_WIDTH/5);
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
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
        GridPane.setMargin(button, new Insets(10));

    }
}
