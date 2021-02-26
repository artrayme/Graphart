package gui.graphwindow;

import gui.EventHandlers;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class GraphNode extends StackPane implements GraphElement{
    private final Label text = new Label("NEW");
    private final Circle circle = new Circle();
    private boolean isActive;

    public GraphNode(double x, double y, double radius) {
        circle.setRadius(radius);
        this.getChildren().addAll(circle, text);
        this.setLayoutX(x - radius);
        this.setLayoutY(y - radius);

        init();
    }

    public void makeCircleActive(){
        if (isActive){
            circle.setStyle("-fx-stroke: orange;");
        }
        else{
            circle.setStyle("-fx-stroke: lightgreen;");
        }
        isActive = !isActive;
    }


    private void init() {
        circle.getStyleClass().add("circle");
        EventHandlers eventHandlers = new EventHandlers();
        setOnMouseClicked(eventHandlers.onMousePressedEventHandler);
        setOnMouseDragged(eventHandlers.onMouseDraggedEventHandler);
    }

    public double getRadius(){
        return circle.getRadius();
    }

    @Override
    public void setText(String text) {
        this.text.setText(text);
    }

    @Override
    public String getText() {
        return this.text.getText();
    }
}
