package lab4.task2.model.vegitable;

import java.util.logging.Logger;

public abstract class Vegetable {
    private static final Logger logger = Logger.getLogger(Vegetable.class.getName());

    private String name;
    private double weight;
    private double caloriesPer100g;

    public Vegetable(String name, double weight, double caloriesPer100g) {
        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;

        logger.info("Создан овощ: " + name);
        logger.fine("Вес: " + weight + " г, калорийность: " + caloriesPer100g + " ккал на 100 г");
    }

    public abstract void prepare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.fine("Изменение названия овоща: " + this.name + " -> " + name);
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        logger.fine("Изменение веса овоща '" + name + "': " + weight + " г");
        this.weight = weight;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(double caloriesPer100g) {
        logger.fine("Изменение калорийности овоща '" + name + "'");
        this.caloriesPer100g = caloriesPer100g;
    }

    public double calculateTotalCalories() {
        double result = (weight / 100) * caloriesPer100g;

        logger.fine("Рассчитана калорийность овоща '" + name + "': " + result + " ккал");

        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "%s (Вес: %.1f г, Калории: %.1f ккал)",
                name, weight, caloriesPer100g
        );
    }
}