package gui.graphwindow;

import javafx.scene.layout.Pane;

public interface GraphElement {
    void setActive(boolean active);

    boolean isActive();
    void setText(String text);

    String getText();
}
