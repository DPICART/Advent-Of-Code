package fr.daart.ex09;

import java.util.HashSet;
import java.util.Set;

public class CordPart {

    private final int order;
    private int x;
    private int y;
    private CordPart prev;
    private CordPart next;

    private final Set<Point> visited = new HashSet<>();

    public CordPart(int order, int x, int y) {
        this.order = order;
        this.x = x;
        this.y = y;
        visited.add(new Point(0, 0));
    }

    public void setNext(CordPart next) {
        this.next = next;
        next.prev = this;
    }

    public boolean isTail() {
        return null == this.next;
    }

    public boolean isHead() {
        return null == this.prev;
    }

    public void move(int quantity, int dX, int dY) {

        for (int i = 0; i < quantity; i++) {
            this.move(dX, dY);
        }

    }

    public void move(int dX, int dY) {
        this.x += dX;
        this.y += dY;

        visited.add(new Point(this.x, this.y));

        next.propagate();

    }

    private void propagate() {

        if (!this.distanceGreaterThan1(prev)) {
            return;
        }

        if (this.x != prev.x && prev.sameLine(this)) {
            var distanceX = prev.x - this.x;
            this.x += distanceX / Math.abs(distanceX);
        } else if (this.y != prev.y && prev.sameRow(this)) {
            var distanceY = prev.y - this.y;
            this.y += distanceY / Math.abs(distanceY);
        } else {
            var distanceY = prev.y - this.y;
            if (distanceY != 0) {
                this.y += distanceY / Math.abs(distanceY);
            }
            var distanceX = prev.x - this.x;
            if (distanceX != 0) {
                this.x += distanceX / Math.abs(distanceX);
            }
        }

        visited.add(new Point(this.x, this.y));

        if (!this.isTail()) {
            next.propagate();
        }
    }

    private boolean distanceGreaterThan1(CordPart prev) {
        return Math.abs(prev.x - this.x) > 1 || Math.abs(prev.y - this.y) > 1;
    }

    private boolean sameRow(CordPart other) {
        return this.y == other.y;
    }

    private boolean sameLine(CordPart other) {
        return this.x == other.x;
    }

    public CordPart getTail() {
        if (isTail()) {
            return this;
        }
        return next.getTail();
    }

    public CordPart addNext() {
        var newCord = new CordPart(this.order + 1, this.x, this.y);
        this.setNext(newCord);
        return newCord;
    }

    public Set<Point> getVisited() {
        return this.visited;
    }
}
