package gui.toolspane;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GraphInformationPane extends GridPane {

    private final Label nodesCount = new Label("0");
    private final Label arcCount = new Label("0");
    private final Label edgesCount = new Label("0");
    private final Label isTree = new Label("false");

    public GraphInformationPane() {
        this.add(new Label("Nodes count = "), 0, 0);
        this.add(new Label("Arcs count = "), 0, 1);
        this.add(new Label("Edges count = "), 0, 2);
        this.add(new Label("Is tree = "), 0, 3);
        this.add(nodesCount, 1, 0);
        this.add(arcCount, 1, 1);
        this.add(edgesCount, 1, 2);
        this.add(isTree, 1, 3);
    }

    public void setNodesCount(String count) {
        nodesCount.setText(count);
    }

    public void setArcsCount(String count) {
        arcCount.setText(count);
    }

    public void setEdgesCount(String count) {
        edgesCount.setText(count);
    }

    public void setIsTree(String status) {
        isTree.setText(status);
    }
}
