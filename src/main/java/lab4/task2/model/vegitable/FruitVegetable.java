package lab4.task2.model.vegitable;

import java.util.logging.Logger;

public class FruitVegetable extends Vegetable {

    private static final Logger logger = Logger.getLogger(FruitVegetable.class.getName());

    private boolean requiresPrepare;

    public FruitVegetable(String name, double weight,
                          double caloriesPer100g, boolean requiresPrepare) {
        super(name, weight, caloriesPer100g);
        this.requiresPrepare = requiresPrepare;

        logger.info("Создан плодовый овощ: " + name);
        logger.fine("Требуется дополнительная подготовка: " + requiresPrepare);
    }

    @Override
    public void prepare() {
        logger.info("Начата подготовка плодового овоща: " + getName());

        if (requiresPrepare) {
            System.out.println("Плодовый овощ: Моем, удаляем семена и режем кубиками -> " + getName());
        } else {
            System.out.println("Плодовый овощ: Моем и режем ломтиками -> " + getName());
        }

        logger.fine("Подготовка плодового овоща завершена: " + getName());
    }

    public boolean isRequiresPrepare() {
        return requiresPrepare;
    }

    public void setRequiresPrepare(boolean requiresPrepare) {
        this.requiresPrepare = requiresPrepare;
        logger.fine("Изменен параметр подготовки овоща '" + getName() + "': " + requiresPrepare);
    }
}