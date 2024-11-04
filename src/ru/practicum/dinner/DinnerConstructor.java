package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> dishes;

    public DinnerConstructor() {
        dishes = new HashMap<String, ArrayList<String>>();
        dishes.put("напиток", new ArrayList<String>());
        dishes.put("гарнир", new ArrayList<String>());
        dishes.put("мясо", new ArrayList<String>());
    }

    static void addDish(String dishName, String dishType) {
        dishType = dishType.toLowerCase();

        if (!dishes.containsKey(dishType)) {
            dishes.put(dishType, new ArrayList<String>());
        }

        var dishesName = dishes.get(dishType);
        dishesName.add(dishName);
        dishes.put(dishType, dishesName);
    }

    static void buildRandomDish(int countCombo, ArrayList<String> dishTypes) {
        var random = new Random();
        for (int i = 0; i < countCombo; i++) {
            StringBuilder combo = new StringBuilder();
            combo.append("Комбо ").append(i + 1).append("\n[");
            for (String dishType : dishTypes) {
                if (!dishes.containsKey(dishType)) {
                    System.out.println("Тип блюда " + dishType + " не существует. Введите другой тип.");
                    return;
                }
                ArrayList<String> dishList = dishes.get(dishType);
                if (dishList != null && !dishList.isEmpty()) {
                    var dishName = dishList.get(random.nextInt(dishList.size()));
                    combo.append(dishName).append(", ");
                }
            }
            if (combo.length() > 2) {
                combo.setLength(combo.length() - 2); // Remove the last comma and space
                combo.append("]");
                System.out.println(combo);
            } else {
                System.out.println("Комбинация не может быть сгенерирована из-за отсутствия блюд.");
            }
        }
    }
}
