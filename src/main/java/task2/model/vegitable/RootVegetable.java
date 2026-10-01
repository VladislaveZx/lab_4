package task2.model.vegitable;

public class RootVegetable extends  Vegetable {

    private boolean requiresPrepare;

    public boolean isRequiresPrepare() {
        return requiresPrepare;
    }

    public void setRequiresPrepare(boolean requiresPrepare) {
        this.requiresPrepare = requiresPrepare;
    }

    @Override
    public void prepare() {
        if (requiresPrepare) {
            System.out.println("Корнеплод: Моем, очищаем от кожуры и натираем -> " + getName());
        }
        else {
            System.out.println("Корнеплод: Тщательно моем и нарезаем -> " + getName());
        }

    }
    public RootVegetable(String name, double weight, double caloriesPer100g, boolean requiresPrepare) {
        super(name, weight, caloriesPer100g);
        this.requiresPrepare = requiresPrepare;
    }
}
