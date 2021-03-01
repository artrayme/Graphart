package gui.graphwindow;

import javafx.scene.layout.Pane;

public abstract class GraphElement extends Pane {
    protected boolean isActive;

    abstract public void setActive(boolean active);

    abstract public boolean isActive();
    abstract public void setText(String text);

    abstract public String getText();
}
