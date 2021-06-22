package model;

public abstract class Cell {
    private boolean isOpened = false;
    private boolean isTagged = false;

    public void setOpened() {
        isOpened = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean isTagged() {
        return isTagged;
    }

    public void changeIsTagged() {
        isTagged = !isTagged;

    }
}
