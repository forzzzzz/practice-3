package org.example;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private void menu() {
        String s = null;
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate,  's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    if (confirmation()){
                        System.out.println("Enter display format ('s'tring or 't'able):");
                        String format = null;
                        try {
                            format = in.readLine();
                        } catch (IOException e) {
                            System.out.println("Error: " + e);
                            System.exit(0);
                        }

                        System.out.println("View current.");
                        Displayable displayable = Calc.createDisplayable();
                        displayable.display(format);
                    }
                    break;
                case 'g':
                    if (confirmation()){
                        System.out.println("Random generation.");

                        // Демонстрація макрокоманди
                        Calc.initAndShowResult(Math.random() * 360.0,
                                Math.random() * 360.0,
                                Math.random() * 360.0,
                                Math.random() * 360.0,
                                Math.random() * 360.0);
                    }
                    break;
                case 's':
                    if (confirmation()){
                        System.out.println("Save current.");
                        try {
                            Calc.save();
                        } catch (IOException e) {
                            System.out.println("Serialization error: " + e);
                        }
                        Calc.show();
                    }
                    break;
                case 'r':
                    if (confirmation()){
                        System.out.println("Restore last saved.");
                        try {
                            Calc.restore();
                        } catch (Exception e) {
                            System.out.println("Serialization error: " + e);
                        }
                        Calc.show();
                    }
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    private boolean confirmation(){
        System.out.println("Confirm action ('y'es or 'n'o)?");
        String confirm = null;
        try {
            confirm = in.readLine();
        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        switch (confirm.charAt(0)){
            case 'y':
                return true;
            case 'n':
                return false;
            default:
                System.out.print("Wrong command.");
        }

        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
