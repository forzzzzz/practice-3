package org.example;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private static List<Item2d> results = new ArrayList<>();

    private Calc() {

    }

    private static void addResult(Item2d result) {
        results.add(result);
    }
    public static void setResult(Item2d result) {
        addResult(result);
    }

    public static List<Item2d> getResults() {
        return results;
    }

    public static String calc(double v, double r) {
        Item2d result = new Item2d(DirectCurrent.calculateDirectCurrent(v, r), v, r);
        addResult(result);
        return result.getBinaryCurrent();
    }

    public static void init(double v, double r) {
        Item2d result = new Item2d(DirectCurrent.calculateDirectCurrent(v, r), v, r);
        addResult(result);
    }

    public static void show() {
        System.out.println();
        for (Item2d result : results) {
            System.out.println(result);
        }
    }

    public static void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(results);
        os.flush();
        os.close();
    }

    public static void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        results.clear();
        is.close();
    }

    public static double calculateMinimum(List<Double> values) {
        return values.parallelStream().min(Double::compareTo).orElse(Double.NaN);
    }

    public static double calculateMaximum(List<Double> values) {
        return values.parallelStream().max(Double::compareTo).orElse(Double.NaN);
    }

    public static double calculateAverage(List<Double> values) {
        return values.parallelStream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    public static List<Double> filterByCriterion(List<Double> values, double criterion) {
        return values.parallelStream().filter(value -> value > criterion).collect(Collectors.toList());
    }
}