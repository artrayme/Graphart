package gui;

import gui.graphwindow.GraphNode;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventHandlers {

    public EventHandler<MouseEvent> onMousePressedEventHandler = event -> {

        GraphNode node = (GraphNode) (event.getSource());
        node.makeCircleActive();

    };

    public EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {
        //ToDo make the offset universal
        //(30 and 85 - bruteforce numbers)
        GraphNode node = (GraphNode) (event.getSource());
        node.setLayoutX(event.getSceneX()-30);
        node.setLayoutY(event.getSceneY()-85);

    };

    public EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {

    };

}

