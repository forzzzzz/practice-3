package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    private void menu() {
        String s;
        try {
            do {
                do {
                    System.out.println("Enter command...");
                    System.out.print("'q'uit, 'v'iew, 'g'enerate,  's'ave, 'r'estore: ");
                    s = in.readLine();
                } while (s.length() != 1);
                switch (s.charAt(0)) {
                    case 'q':
                        System.out.println("Выход.");
                        break;
                    case 'v':
                        if (confirmation()) {
                            System.out.println("Enter display format ('s'tring or 't'able): ");
                            String format = in.readLine();
                            System.out.println("View current.");
                            Displayable displayable = Calc.createDisplayable();
                            displayable.display(format);
                            Calc.showValues();
                        }
                        break;
                    case 'g':
                        if (confirmation()) {
                            System.out.println("Random generation.");
                            executor.execute(() -> {
                                Calc.initAndShowResult(Math.random() * 360.0,
                                        Math.random() * 360.0,
                                        Math.random() * 360.0,
                                        Math.random() * 360.0,
                                        Math.random() * 360.0);
                                Calc.showValues();
                            });
                        }
                        break;
                    case 's':
                        if (confirmation()) {
                            System.out.println("Save current.");
                            executor.execute(() -> {
                                try {
                                    Calc.save();
                                } catch (IOException e) {
                                    System.out.println("Serialization error: " + e);
                                }
                                Calc.show();
                                Calc.showValues();
                            });
                        }
                        break;
                    case 'r':
                        if (confirmation()) {
                            System.out.println("Restore last saved.");
                            executor.execute(() -> {
                                try {
                                    Calc.restore();
                                } catch (Exception e) {
                                    System.out.println("Serialization error: " + e);
                                }
                                Calc.show();
                                Calc.showValues();
                            });
                        }
                        break;
                    default:
                        System.out.print("Wrong command. ");
                }
            } while (s.charAt(0) != 'q');
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            executor.shutdown();
        }
    }

    private boolean confirmation() throws IOException {
        System.out.println("Confirm action ('y'es or 'n'o)?");
        String confirm = in.readLine();
        switch (confirm.charAt(0)) {
            case 'y':
                return true;
            case 'n':
                return false;
            default:
                System.out.print("Wrong command.");
                return false;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}