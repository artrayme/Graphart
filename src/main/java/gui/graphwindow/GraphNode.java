package gui.graphwindow;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class GraphNode extends Circle implements GraphElement {
    //    private final StackPane mainLayout = new StackPane();
//    private final Label text = new Label("NEW");
//    private final Circle circle = new Circle();
    private static final String FONT_FAMILY = "Segoe UI";
    private final Text text = new Text();
    private boolean isActive;

    public GraphNode(double x, double y, double radius) {
        setStrokeType(StrokeType.OUTSIDE);

        this.setRadius(radius);
//        text.setStyle("-fx-text-fill: #ff0000;");
//        mainLayout.getChildren().addAll(circle, text);
//        mainLayout.setLayoutX(x - radius);
//        mainLayout.setLayoutY(y - radius);
//        this.getChildren().add(circle);
        setCenterX(x);
        setCenterY(y);
//        text.setFont(Font.font(FONT_FAMILY, FontPosture.ITALIC, 3 * radius / 2));
////        text.setText(sourwceNode.getName());
//        text.setFill(Color.BLACK);
//        text.setStrokeWidth(14);
////        text.setX(300);
////        text.setY(300);
//        text.xProperty().bind(centerXProperty().add(3 * radius / 2));
//        text.yProperty().bind(centerYProperty().add(-radius));
//        text.setText("aaaaaaaaa");
//        text.setStyle("-fx-text-fill: #ff0000;");
        text.setFont(Font.font(FONT_FAMILY, FontPosture.ITALIC, 3 * radius / 2));
        text.setText("qwertyuiop[");
        text.setFill(Color.GRAY);
        text.setStrokeWidth(20);
        text.xProperty().bind(this.centerXProperty().add(3 * radius / 2));
        text.yProperty().bind(this.centerYProperty().add(-radius));
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
//        text.setStyle("-fx-text-fill: #ff0000;");

//        GraphElementEventHandler eventHandlers = new GraphElementEventHandler();
//        setOnMouseClicked(eventHandlers.onMouseClickedEventHandler);
//        setOnMouseDragged(eventHandlers.onMouseDraggedEventHandler);
        setOnMouseDragged(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)){
            setCenterX(event.getX());
            setCenterY(event.getY());
//            }
        });
//        text.setText("qwertyuiop");
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

//    public void setX(double x) {
//        mainLayout.setLayoutX(x - radius);
//    }
//
//    public void setY(double y) {
//        mainLayout.setLayoutY(y - radius);
//    }
}
