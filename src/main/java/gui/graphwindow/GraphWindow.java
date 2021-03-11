package gui.graphwindow;

import graph.Graph;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphWindow extends ScrollPane {
    Logger log = Logger.getLogger(GraphWindow.class.getName());

    private final Graph<GraphElement, GraphElement> graph = new Graph<>();
    private final AnchorPane drawArea = new AnchorPane();

    private final List<GraphElement> selectedElements = new LinkedList<>();

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
                    Node node = (Node) graph.addNode(new GraphNode(mouseEvent.getX(), mouseEvent.getY(), 30, drawArea));
                    drawArea.getChildren().addAll(node);
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

    public AnchorPane getDrawArea() {
        return drawArea;
    }
}
