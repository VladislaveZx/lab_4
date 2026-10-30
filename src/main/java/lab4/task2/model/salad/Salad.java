package lab4.task2.model.salad;

import lab4.task2.model.vegitable.Vegetable;

import java.util.Arrays;
import java.util.logging.Logger;

public class Salad {
    private static final Logger logger = Logger.getLogger(Salad.class.getName());

    private String name;
    private Vegetable[] ingredients;
    private int capacity;

    public Salad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.ingredients = new Vegetable[0];

        logger.info("Создан салат: " + name);
        logger.fine("Начальная вместимость салата: " + capacity);
    }

    public void addVegetable(Vegetable vegetable) {
        if (vegetable == null) {
            logger.warning("Попытка добавить пустой овощ в салат: " + name);
            return;
        }

        if (ingredients.length >= capacity) {
            logger.warning("Невозможно добавить овощ. Салат '" + name + "' заполнен");
            return;
        }

        ingredients = Arrays.copyOf(ingredients, ingredients.length + 1);
        ingredients[ingredients.length - 1] = vegetable;

        logger.info("В салат '" + name + "' добавлен овощ: " + vegetable.getName());
        logger.fine("Количество ингредиентов: " + ingredients.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.fine("Изменение названия салата с '" + this.name + "' на '" + name + "'");
        this.name = name;
    }

    public Vegetable[] getIngredients() {
        return ingredients;
    }

    public void setVegetable(Vegetable[] vegetable) {
        if (vegetable == null) {
            logger.warning("Попытка установить пустой массив ингредиентов");
            return;
        }

        if (vegetable.length > capacity) {
            logger.warning("Количество ингредиентов превышает вместимость салата");
            return;
        }

        this.ingredients = vegetable;
        logger.info("Обновлен список ингредиентов салата: " + name);
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", vegetable=" + Arrays.toString(ingredients) +
                '}';
    }
}