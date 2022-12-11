package fr.daart.y2022.ex11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Monkey {

    private String name;
    private ArrayList<Item> items;
    private Function<Long, Long> operation;
    private Function<Long, Integer> test;
    private long divisor;
    private int targetSuccess;
    private int targetFail;

    private long inspectionCount = 0;

    public Monkey(String name, ArrayList<Item> items, Function<Long, Long> operation, Function<Long, Integer> test, int testResp1, int testResp2, long divisor) {
        this.name = name;
        this.items = items;
        this.operation = operation;
        this.test = test;
        this.targetSuccess = testResp1;
        this.targetFail = testResp2;
        this.divisor = divisor;
    }

    public static Monkey fromString(String rawMonkey) {


        var split = rawMonkey.split("  ");
        var name = split[0];
        var rawItems = split[1].replace("Starting items: ", "").split(", ");

        var newItems = new ArrayList<Item>();
        for (var rawItem : rawItems) {
            var item = Item.from(rawItem);
            newItems.add(item);
        }


        var rawOperation = split[2].replace("Operation: ", "");
        var operation = getOperation(rawOperation);

        var split2 = rawMonkey.split("    ");
        var testResp1 = Integer.parseInt(split2[1].replace("If true: throw to monkey ", "").trim());
        var testResp2 = Integer.parseInt(split2[2].replace("If false: throw to monkey ", "").trim());

        var rawTest = split[3].replace("Test: ", "");

        var divisionCheckValue = Long.parseLong(rawTest.split("divisible by ")[1].trim());
        var diviser = Long.valueOf(divisionCheckValue);

        Function<Long, Integer> test = (Long aNumber) -> { return aNumber % diviser == 0 ? testResp1 : testResp2; };

        return new Monkey(
                name,
                newItems,
                operation,
                test,
                testResp1,
                testResp2,
                divisionCheckValue
        );
    }

    private static Function<Long, Long> getOperation(String rawOperation) {

        var isAddition = rawOperation.contains("+");
        var isMultiplication = rawOperation.contains("*");

        var split = rawOperation.split(" = ");
        if (isAddition) {
            var split2 = split[1].split("\\+");
            var left = split2[0].trim();
            var right = split2[1].trim();
            return getAddition(left, right);
        } else if (isMultiplication) {
            var split2 = split[1].split("\\*");
            var left = split2[0].trim();
            var right = split2[1].trim();
            return getMultiplication(left, right);
        } else {
            throw new IllegalArgumentException("Operation not supported");
        }


    }

    private static Function<Long, Long> getAddition(String left, String right) {

        var isLeftOld = left.contains("old");
        var isRightOld = right.contains("old");

        if (isLeftOld) {
            if (isRightOld) {
                return old -> old + old;
            } else {
                return old -> old + Long.parseLong(right);
            }
        } else {
            if (isRightOld) {
                return old -> Long.parseLong(left) + old;
            } else {
                return old -> Long.parseLong(left) + Long.parseLong(right);
            }
        }

    }


    private static Function<Long, Long> getMultiplication(String left, String right) {

        var isLeftOld = left.contains("old");
        var isRightOld = right.contains("old");

        if (isLeftOld) {
            if (isRightOld) {
                return old -> old * old;
            } else {
                return old -> old * Long.parseLong(right);
            }
        } else {
            if (isRightOld) {
                return old -> Long.parseLong(left) * old;
            } else {
                return old -> Long.parseLong(left) * Long.parseLong(right);
            }
        }


    }

    public Map<Long, ArrayList<Item>> inspect(boolean isBored, Long commonDivisor) {

        if (items.isEmpty()) {
            return Map.of();
        }

        Map<Long, ArrayList<Item>> transferMap = new HashMap<>();

        while (!items.isEmpty()) {
            var currentItem = items.remove(0);

            if(!isBored) {
                currentItem.reduce(commonDivisor);
            }


            currentItem.apply(operation);

            if (isBored) {
                currentItem.getBored();
            }

            var newMonkey = test.apply(currentItem.getWorryLevel());

            var newMapValue = transferMap.getOrDefault(newMonkey.longValue(), new ArrayList<>());
            newMapValue.add(currentItem);

            transferMap.put(newMonkey.longValue(), newMapValue);
            inspectionCount++;

        }
        return transferMap;
    }

    public void addItems(ArrayList<Item> items) {
        this.items.addAll(items);
    }

    public long getInspectionCount() {
        return inspectionCount;
    }

    public String getName() {
        return this.name;
    }

    public String getStringItemsWorryLevels() {

        return items.stream().map(i -> String.valueOf(i.getWorryLevel())).reduce((a, b) -> a + ", " + b).orElseGet(() -> "");

    }

    public long getDivisor() {
        return divisor;
    }
}
