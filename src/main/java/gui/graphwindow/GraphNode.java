package gui.graphwindow;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class GraphNode extends Circle implements GraphElement {
    private static final String FONT_FAMILY = "Segoe UI";
    private final Text text = new Text();
    private boolean isActive;

    public GraphNode(double x, double y, double radius, AnchorPane pane) {
        setStrokeType(StrokeType.OUTSIDE);

        this.setRadius(radius);
        setCenterX(x);
        setCenterY(y);
        text.setFont(Font.font(FONT_FAMILY, FontPosture.ITALIC, 3 * radius / 2));
        text.setFill(Color.GRAY);
        text.setStrokeWidth(20);
        text.xProperty().bind(this.centerXProperty().add(3 * radius / 2));
        text.yProperty().bind(this.centerYProperty().add(-radius));
        pane.getChildren().addAll(text);

        init();
    }

    public void setStrokeColor(Color color) {
        setStroke(color);
    }

    public void makeGreen() {
        setStyle("-fx-stroke: lightgreen;");
    }

    public void makeOrange() {
        setStyle("-fx-stroke: orange;");
    }

    private void init() {
        getStyleClass().add("circle");
        setOnMouseDragged(event -> {
            setCenterX(event.getX());
            setCenterY(event.getY());
            isActive = !isActive;
        });
        setOnMousePressed(event -> {
            setActive(!isActive);

        });
    }

    @Override
    public void setActive(boolean active) {
        this.isActive = active;
        if (isActive)
            makeGreen();
        else
            makeOrange();
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

}
