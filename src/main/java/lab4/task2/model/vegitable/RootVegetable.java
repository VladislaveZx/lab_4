package lab4.task2.model.vegitable;

import java.util.logging.Logger;

public class RootVegetable extends Vegetable {

    private static final Logger logger = Logger.getLogger(RootVegetable.class.getName());

    private boolean requiresPrepare;

    public RootVegetable(String name, double weight,
                         double caloriesPer100g, boolean requiresPrepare) {
        super(name, weight, caloriesPer100g);
        this.requiresPrepare = requiresPrepare;

        logger.info("Создан корнеплод: " + name);
        logger.fine("Требуется очистка: " + requiresPrepare);
    }

    public boolean isRequiresPrepare() {
        return requiresPrepare;
    }

    public void setRequiresPrepare(boolean requiresPrepare) {
        this.requiresPrepare = requiresPrepare;
        logger.fine("Изменен параметр подготовки корнеплода '" + getName() + "'");
    }

    @Override
    public void prepare() {
        logger.info("Начата подготовка корнеплода: " + getName());

        if (requiresPrepare) {
            System.out.println("Корнеплод: Моем, очищаем от кожуры и натираем -> " + getName());
        } else {
            System.out.println("Корнеплод: Тщательно моем и нарезаем -> " + getName());
        }

        logger.fine("Подготовка корнеплода завершена: " + getName());
    }
}