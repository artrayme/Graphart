package gui;

import gui.graphwindow.GraphElement;
import gui.graphwindow.GraphNode;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GraphElementEventHandler {

    public EventHandler<MouseEvent> onMouseClickedEventHandler = event -> {

        GraphElement element = (GraphElement) (event.getSource());
        element.setActive(!element.isActive());
    };

    public EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {
        GraphNode node = (GraphNode) (event.getSource());
        node.setX(event.getX());
        node.setY(event.getY());

    };

    public EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {

    };

}

