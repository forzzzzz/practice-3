package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String[]> languages = new HashMap<>();
        languages.put("Фрондент", new String[]{"HTML", "CSS", "JavaScript"});
        languages.put("Мобильная разработка", new String[]{"Kotlin", "Swift", "React Native", "Dart"});
        languages.put("Геймдев", new String[]{"С++", "С#"});
        languages.put("Бэкенд", new String[]{"Java", "Python", "C#"});

        System.out.println("Доступные категории языков программирования:");
        for (String category : languages.keySet()) {
            System.out.println(category);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите категорию: ");
        String selectedCategory = scanner.nextLine();

        if (languages.containsKey(selectedCategory)) {
            System.out.println("Языки программирования в категории " + selectedCategory + ":");
            for (String language : languages.get(selectedCategory)) {
                System.out.println(language);
            }
        } else {
            System.out.println("Неверная категория");
        }
    }
}