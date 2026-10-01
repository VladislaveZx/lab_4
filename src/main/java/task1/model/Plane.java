package task1.model;


import java.util.Arrays;

// Класс Самолет (использует Крыло, Шасси, Двигатель)
public class Plane {
    private String model;
    private String[] route;
    private Engine engine;
    private Wing leftWing;
    private Wing rightWing;
    private Chassis chassis;


    //контструктор без параметров
    public Plane() {
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", route=" + Arrays.toString(route) +
                ", engine=" + engine +
                ", leftWing=" + leftWing +
                ", rightWing=" + rightWing +
                ", chassis=" + chassis +
                '}';
    }

    // Конструктор
    public Plane(String model) {
        this.model = model;
        this.engine = new Engine();
        this.leftWing = new Wing("Левое");
        this.rightWing = new Wing("Правое");
        this.chassis = new Chassis();
        this.route = new String[]{};
    }

    // Метод: задавать маршрут
    public void setRoute(String[] route) {
        this.route = route;
        System.out.println("Диспетчер: Маршрут обновлен.");
    }

    // Метод: вывести на консоль маршрут
    public void printRoute() {
        System.out.println("Текущий маршрут борта " + model + ": " + Arrays.toString(route));
    }

    public void fly() {
        System.out.println("\n--- Начинаем выполнение рейса ---");
        engine.start();
        System.out.println("Взлет...");
        chassis.retract();
        System.out.println("Самолет " + model + " успешно летит по маршруту: " + Arrays.toString(route));
    }
}

