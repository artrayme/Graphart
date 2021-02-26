package gui.graphwindow;

import graph.Graph;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphWindow extends ScrollPane {
    Logger log = Logger.getLogger(GraphWindow.class.getName());

    private final Graph<String, String> graph = new Graph<>();
    private final AnchorPane drawArea = new AnchorPane();

    public GraphWindow() {
        log.addHandler(new ConsoleHandler());

        init();
        this.setContent(drawArea);
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

    public void deleteSelectedNodes() {
        log.log(Level.INFO, "delete selected nodes");

    }

    public void addNewNode() {
        log.log(Level.INFO, "add new node");

    }

    public void connectNodesWithArcs() {
        log.log(Level.INFO, "connect selected nodes with arcs");

    }

    public void connectNodesWithEdges() {
        log.log(Level.INFO, "connect selected nodes with edges");

    }

    public void addTextForSelectedElement() {
        log.log(Level.INFO, "add text for selected element");

    }

}
