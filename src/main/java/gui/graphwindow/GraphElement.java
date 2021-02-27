package gui.graphwindow;

import javafx.scene.layout.Pane;

public abstract class GraphElement extends Pane {
    private boolean isActive;

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    abstract public void setText(String text);

    abstract public String getText();
}
