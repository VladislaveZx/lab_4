package lab4.task2.service;

import lab4.task2.model.salad.Salad;
import lab4.task2.model.vegitable.Vegetable;

import java.util.logging.Logger;

public class ChefService {

    private static final Logger logger = Logger.getLogger(ChefService.class.getName());

    public void makeSalad(Salad salad) {
        if (salad == null) {
            logger.warning("Попытка приготовить несуществующий салат");
            return;
        }

        logger.info("Шеф-повар начал приготовление салата: " + salad.getName());

        System.out.println("\nШеф-повар готовит салат '" + salad.getName() + "':");

        for (Vegetable v : salad.getIngredients()) {
            if (v != null) {
                v.prepare();
            }
        }

        System.out.println("Салат: " + salad.getName() + " готов!");

        logger.info("Приготовление салата завершено: " + salad.getName());
    }

    public double calculateTotalCalories(Salad salad) {
        if (salad == null) {
            logger.warning("Попытка рассчитать калорийность несуществующего салата");
            return 0;
        }

        logger.info("Начат расчет калорийности салата: " + salad.getName());

        double totalCalories = 0;

        for (Vegetable v : salad.getIngredients()) {
            if (v != null) {
                totalCalories += v.calculateTotalCalories();
            }
        }

        logger.info("Общая калорийность салата '" + salad.getName() +
                "': " + totalCalories + " ккал");

        return totalCalories;
    }

    public Vegetable[] findVegetablesByCaloriesRange(
            Salad salad, double min, double max) {

        if (salad == null || min > max) {
            logger.warning("Некорректные параметры поиска овощей по калорийности");
            return new Vegetable[0];
        }

        logger.info("Поиск овощей по диапазону калорийности: " + min + " - " + max);

        Vegetable[] vegetables = salad.getIngredients();
        int matchCount = countMatching(vegetables, min, max);

        Vegetable[] result = extractMatching(vegetables, matchCount, min, max);

        logger.info("Найдено овощей: " + result.length);

        return result;
    }

    private int countMatching(Vegetable[] vegetable, double min, double max) {
        int count = 0;

        for (Vegetable v : vegetable) {
            if (isWithinRange(v, min, max)) {
                count++;
            }
        }

        logger.fine("Количество подходящих овощей: " + count);

        return count;
    }

    private Vegetable[] extractMatching(
            Vegetable[] vegetable, int size, double min, double max) {

        Vegetable[] vegetables = new Vegetable[size];
        int index = 0;

        for (Vegetable v : vegetable) {
            if (isWithinRange(v, min, max)) {
                vegetables[index++] = v;
            }
        }

        return vegetables;
    }

    private boolean isWithinRange(Vegetable vegetable, double min, double max) {
        if (vegetable == null) {
            return false;
        }

        double vegetableCalories = vegetable.calculateTotalCalories();

        return vegetableCalories >= min && vegetableCalories <= max;
    }

    public void sortVegetablesByWeight(Salad salad) {
        if (salad == null) {
            logger.warning("Попытка сортировки овощей в несуществующем салате");
            return;
        }

        logger.info("Начата сортировка овощей по весу в салате: " + salad.getName());

        Vegetable[] ingredients = salad.getIngredients();

        sortArray(ingredients);

        printIngredients(ingredients);

        logger.info("Сортировка овощей завершена");
    }

    private void sortArray(Vegetable[] ingredients) {
        for (int i = 0; i < ingredients.length - 1; i++) {
            for (int j = i + 1; j < ingredients.length; j++) {
                if (shouldSwap(ingredients[i], ingredients[j])) {
                    swap(ingredients, i, j);
                }
            }
        }

        logger.fine("Массив овощей отсортирован по убыванию веса");
    }

    private boolean shouldSwap(Vegetable left, Vegetable right) {
        if (left == null && right != null) {
            return true;
        }

        if (left != null && right != null) {
            return left.getWeight() < right.getWeight();
        }

        return false;
    }

    private void swap(Vegetable[] array, int i, int j) {
        Vegetable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void printIngredients(Vegetable[] ingredients) {
        System.out.println("Овощи отсортированы по весу:");

        for (Vegetable v : ingredients) {
            if (v != null) {
                System.out.println("- " + v.getName() + ": " + v.getWeight() + " г.");
            }
        }
    }
}