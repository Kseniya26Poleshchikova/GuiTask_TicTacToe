package com.codebind;


import java.util.function.Predicate;

public  class Logic {
    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure> predicate,
                          int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkX, this.table.length - 1, 0, -1, 1);
    }
    public boolean isWinnerO() {
        return this.fillBy(Figure::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkO, this.table.length - 1, 0, -1, 1);
    }



    public boolean hasGap() {
        boolean result = true;
        for (int row = 0; row < this.table.length; row++) {
            result = true;
            for (int cell = 0; cell < this.table.length - 1; cell++) {
                if ((this.table[row][cell].hasMarkO() || this.table[row][cell].hasMarkX())) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}