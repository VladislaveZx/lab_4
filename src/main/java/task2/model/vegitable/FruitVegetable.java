package task2.model.vegitable;

public class FruitVegetable extends Vegetable {

    private boolean requiresPrepare;

    @Override
    public void prepare() {
        if (requiresPrepare) {
            System.out.println("Плодовый овощ: Моем, удаляем семена и режем кубиками -> " + getName());
        } else {
            System.out.println("Плодовый овощ: Моем и режем ломтиками -> " + getName());
        }
    }

    public boolean isRequiresPrepare() {
        return requiresPrepare;
    }

    public void setRequiresPrepare(boolean requiresPrepare) {
        this.requiresPrepare = requiresPrepare;
    }

    public FruitVegetable(String name, double weight, double caloriesPer100g, boolean requiresPrepare) {
        super(name, weight, caloriesPer100g);
        this.requiresPrepare = requiresPrepare;
    }
}
