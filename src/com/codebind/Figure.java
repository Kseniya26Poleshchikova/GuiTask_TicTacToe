package com.codebind;
import javafx.scene.shape.Rectangle;

public class Figure extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure() {
    }

    public Figure(boolean markX, boolean mark0) {
        this.markX = markX;
        this.markO = mark0;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }
}
