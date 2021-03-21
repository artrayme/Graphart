package gui.toolspane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.*;

public class NodeEditPane extends VBox {
    private final Button removeNodeButton = new Button("Remove");

    private final Label setNodeStringLabel = new Label("Set node label");
    private final TextField nodeString = new TextField();

    private final Label setNodeRadiusLabel = new Label("Set node radius");
    private final TextField nodeRadius = new TextField();

    public NodeEditPane(){
        init();
    }

    private void init() {
        initRemoveButton();
        this.getChildren().add(removeNodeButton);
        this.getChildren().add(setNodeStringLabel);
        this.getChildren().add(nodeString);
        this.getChildren().add(setNodeRadiusLabel);
        this.getChildren().add(nodeRadius);
    }

    private void initRemoveButton() {
        removeNodeButton.getStyleClass().add("-fx-background-color: #424241, red, red, #424241;\n");
        removeNodeButton.setOnMouseClicked(e->{

        });
    }

}
