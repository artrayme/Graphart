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
    private double x;
    private double y;
    private double radius;

    public GraphNode(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        circle.setRadius(radius);
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

    public void setX(double x) {
        this.x = x;
        mainLayout.setLayoutX(x - radius);
    }

    public void setY(double y) {
        this.y = y;
        mainLayout.setLayoutY(y - radius);
    }
}
