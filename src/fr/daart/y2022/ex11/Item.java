package fr.daart.y2022.ex11;

import java.util.function.Function;

public class Item {

    private long worryLevel;

    public Item(long worryLevel) {
        this.worryLevel = worryLevel;
    }


    public static Item from(String rawItem) {

        var value = Integer.parseInt(rawItem.replace("\r\n", ""));
        return new Item(value);
    }

    public long getWorryLevel() {
        return worryLevel;
    }

    public void apply(Function<Long, Long> operation) {
        this.worryLevel = operation.apply(this.worryLevel);
    }

    public void getBored() {
        this.worryLevel = this.worryLevel / 3;
    }

    public void reduce(Long commonDivisor) {

        if(this.worryLevel > commonDivisor) {
            this.worryLevel = this.worryLevel % commonDivisor;
        }

    }
}
