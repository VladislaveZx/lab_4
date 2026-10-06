package lab4.task2.model.salad;

import lab4.task2.model.vegitable.Vegetable;

import java.util.Arrays;

public class Salad {
    private String name;

    private Vegetable[] ingredients;

    public Salad(String name, int capacity) {
        this.name = name;
        this.ingredients = new Vegetable[0];
    }

    public void addVegetable(Vegetable vegetable) {
        ingredients = Arrays.copyOf(ingredients, ingredients.length + 1);
        ingredients[ingredients.length - 1] = vegetable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vegetable[] getIngredients() {
        return ingredients;
    }

    public void setVegetable(Vegetable[] vegetable) {
        this.ingredients = vegetable;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", vegetable=" + Arrays.toString(ingredients) +
                '}';
    }
}

