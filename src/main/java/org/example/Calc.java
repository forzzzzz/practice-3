package org.example;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private static Item2d result = new Item2d();
    private static final DirectCurrent directCurrent = new DirectCurrent();

    private Calc() {

    }

    public static void setResult(Item2d result) {
        Calc.result = result;
    }

    public static Item2d getResult() {
        return result;
    }

    public static String calc(double v, double r1, double r2, double r3, double r4) {
        result = directCurrent.calculateDirectCurrent(v, r1, r2, r3, r4);
        return result.getBinaryCurrent();
    }

    public static String init(double v, double r1, double r2, double r3, double r4) {
        result = directCurrent.calculateDirectCurrent(v, r1, r2, r3, r4);
        return result.getBinaryCurrent();
    }

    public static void show() {
        System.out.println(result);
    }

    //Макрокоманда
    public static void initAndShowResult(double v, double r1, double r2, double r3, double r4){
        init(v, r1, r2, r3, r4);
        show();
    }

    public static void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    public static void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
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

    public static void showValues() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.submit(() -> {
            double min = calculateMinimum(result.getValues());
            System.out.println("Minimum value: " + min);
        });

        executor.submit(() -> {
            double max = calculateMaximum(result.getValues());
            System.out.println("Maximum value: " + max);
        });

        executor.submit(() -> {
            double average = calculateAverage(result.getValues());
            System.out.println("Average value: " + average);
        });

        double criterion = 10.0;
        executor.submit(() -> {
            List<Double> filteredValues = filterByCriterion(result.getValues(), criterion);
            System.out.println("Values greater than " + criterion + ": " + filteredValues);
        });

        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Execution interrupted");
        }
    }

    public static Displayable createDisplayable() {
        return new Displayable() {
            @Override
            public void display(String format) {
                result.display(format);
            }
        };
    }
}