package gui.graphwindow;

import graph.Graph;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class GraphWindow extends ScrollPane {
    private final Graph<String, String> graph = new Graph<>();
    private final AnchorPane drawArea = new AnchorPane();

    public GraphWindow() {
        init();
        this.setContent(drawArea);
//        this.getStyleClass().add("scroll-pane");
        drawArea.getStyleClass().add("draw-area");
        drawArea.setMinSize(4000, 4000);

    }

    private void init() {
        drawArea.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    drawArea.getChildren().addAll(new GraphNode(mouseEvent.getX(), mouseEvent.getY(), 30));
                }
            }
        });

    }

}
