package gui.graphwindow;

import gui.GraphElementEventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphNode extends GraphElement{
    private final StackPane mainLayout = new StackPane();
    private final Label text = new Label("NEW");
    private final Circle circle = new Circle();
    private double radius;

    public GraphNode(double x, double y, double radius) {
        this.radius = radius;
        circle.setRadius(radius);
        text.setStyle("-fx-text-fill: #424241;");
        mainLayout.getChildren().addAll(circle, text);
        mainLayout.setLayoutX(x - radius);
        mainLayout.setLayoutY(y - radius);
        this.getChildren().add(mainLayout);
        init();
    }

    public void setStrokeColor (Color color){
        circle.setStroke(color);
    }

    public void makeGreen(){
        circle.setStyle("-fx-stroke: lightgreen;");
    }

    public void makeOrange(){
        circle.setStyle("-fx-stroke: orange;");
    }

    private void init() {
        circle.getStyleClass().add("circle");
        GraphElementEventHandler eventHandlers = new GraphElementEventHandler();
        setOnMouseClicked(eventHandlers.onMouseClickedEventHandler);
        setOnMouseDragged(eventHandlers.onMouseDraggedEventHandler);
    }

    public double getRadius(){
        return circle.getRadius();
    }

    @Override
    public void setActive(boolean active) {
        this.isActive = active;
        if (isActive) makeGreen();
        else makeOrange();
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setText(String text) {
        this.text.setText(text);
    }

    @Override
    public String getText() {
        return this.text.getText();
    }

    public void setX(double x) {
        mainLayout.setLayoutX(x - radius);
    }

    public void setY(double y) {
        mainLayout.setLayoutY(y - radius);
    }
}
