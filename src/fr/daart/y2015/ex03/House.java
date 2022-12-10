package fr.daart.y2015.ex03;

import java.util.Objects;

public record House(int x, int y) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return x == house.x && y == house.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
