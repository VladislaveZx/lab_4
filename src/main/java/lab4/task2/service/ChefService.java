package lab4.task2.service;

import lab4.task2.model.salad.Salad;
import lab4.task2.model.vegitable.Vegetable;

public class ChefService {
    public void makeSalad(Salad salad) {
        System.out.println("\nШеф-повар готовит салат '" + salad.getName() + "':");
        for (Vegetable v: salad.getIngredients()) {
            v.prepare();
        }
        System.out.println("Салат: " + salad.getName() + " готов!");
    }

    public double calculateTotalCalories(Salad salad) {
        double totalCalories = 0;
        for (Vegetable v: salad.getIngredients()) {
            totalCalories+=v.calculateTotalCalories();
        }
        return totalCalories;
    }

    public Vegetable[] findVegetablesByCaloriesRange(Salad salad, double min, double max) {
        Vegetable[] vegetables = salad.getIngredients();
        int matchCount = countMatching(vegetables, min, max);

        return extractMatching(vegetables, matchCount, min, max);
    }

    private int countMatching(Vegetable[] vegetable, double min, double max) {
        int count = 0;
        for (Vegetable v: vegetable) {
            if(isWithinRange(v, min, max)){
                count++;
            }
        }
        return count;
    }

    private Vegetable[] extractMatching(Vegetable[] vegetable, int size, double min, double max) {
        Vegetable[] vegetables = new Vegetable[size];
        int index = 0;
        for (Vegetable v: vegetable) {
            if(isWithinRange(v, min, max)){
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
        Vegetable[] ingredients = salad.getIngredients();
        sortArray(ingredients);
        printIngredients(ingredients);
    }

    private void sortArray(Vegetable[] ingredients) {
        for (int i = 0; i < ingredients.length - 1; i++) {
            for (int j = i + 1; j < ingredients.length; j++) {
                if (shouldSwap(ingredients[i], ingredients[j])) {
                    swap(ingredients, i, j);
                }
            }
        }
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
