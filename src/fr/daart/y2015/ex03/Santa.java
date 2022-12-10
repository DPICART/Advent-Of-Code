package fr.daart.y2015.ex03;

import java.util.HashSet;
import java.util.Set;

public class Santa {

    private int x = 0;
    private int y = 0;
    private Set<House> visited = new HashSet<>();

    public Santa() {
        visited.add(new House(0,0));
    }

    public void move(String movement) {
        switch (movement) {
            case ">" -> x++;
            case "<" -> x--;
            case "^" -> y++;
            case "v" -> y--;
        }
        visited.add(new House(x, y));
    }

    public int getHouseVisitedOnce() {
        return visited.size(); // + start point
    }

    public Set<House> getVisited() {
        return visited;
    }
}
