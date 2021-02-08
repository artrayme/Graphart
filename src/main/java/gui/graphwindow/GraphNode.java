package gui.graphwindow;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class GraphNode extends StackPane {
    private final Label text = new Label("NEW");
    private final Circle circle = new Circle();

    public GraphNode(double x, double y, double radius) {
        circle.setRadius(radius);
        this.getChildren().addAll(circle, text);
        this.setLayoutX(x - radius);
        this.setLayoutY(y - radius);

        init();
    }


    private void init() {
        circle.getStyleClass().add("circle");
    }


}
