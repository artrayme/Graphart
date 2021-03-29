package gui.graphwindow;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.awt.*;

public class GraphEdge extends Rectangle implements GraphElement {
    private static final String FONT_FAMILY = "Segoe UI";
    private final Text text = new Text();
    private boolean isActive;

    private GraphNode firstNode;
    private GraphNode secondNode;

    public GraphEdge(GraphNode firstNode, GraphNode secondNode, AnchorPane pane) {
        setRect(firstNode.getCenterX(), firstNode.getCenterY(), firstNode.getCenterX()+secondNode.getCenterX(), firstNode.getCenterY()+secondNode.getCenterY());
//        text.setFont(Font.font(FONT_FAMILY, FontPosture.ITALIC, 3 * radius / 2));
//        text.setFill(javafx.scene.paint.Color.GRAY);
//        text.setStrokeWidth(20);
//        text.xProperty().bind(this.centerXProperty().add(3 * radius / 2));
//        text.yProperty().bind(this.centerYProperty().add(-radius));
//        pane.getChildren().addAll(text);

        init();
    }

//    public void setStrokeColor(Color color) {
//        setStroke(color);
//    }
//
//    public void makeGreen() {
//        setStyle("-fx-stroke: lightgreen;");
//    }
//
//    public void makeOrange() {
//        setStyle("-fx-stroke: orange;");
//    }

    private void init() {
//        getStyleClass().add("circle");
//        setOnMouseDragged(event -> {
//            setCenterX(event.getX());
//            setCenterY(event.getY());
//            isActive = !isActive;
//        });
//        setOnMousePressed(event -> {
//            setActive(!isActive);
//        });
    }

    @Override
    public void setActive(boolean active) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setText(String text) {

    }

    @Override
    public String getText() {
        return null;
    }

    public void setFirstNode(GraphNode firstNode) {
        this.firstNode = firstNode;
    }

    public void setSecondNode(GraphNode secondNode) {
        this.secondNode = secondNode;
    }

    public GraphNode getFirstNode() {
        return firstNode;
    }

    public GraphNode getSecondNode() {
        return secondNode;
    }
}
