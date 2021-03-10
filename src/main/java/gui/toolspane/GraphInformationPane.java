package gui.toolspane;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GraphInformationPane extends GridPane {

    public GraphInformationPane(){
        this.add(new Label("Nodes count = "), 0, 0);
        this.add(new Label("Arcs count = "), 0, 1);
        this.add(new Label("Edges count = "), 0, 2);
        this.add(new Label("Is tree = "), 0, 3);

    }
}
