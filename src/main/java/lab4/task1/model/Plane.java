
package lab4.task1.model;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

// Класс Самолет (использует Крыло, Шасси, Двигатель)
public class Plane {
    private String model;
    private String[] route;
    private Engine engine;
    private Wing leftWing;
    private Wing rightWing;
    private Chassis chassis;

    private static final Logger LOGGER =
            Logger.getLogger(Plane.class.getName());

    // Конструктор без параметров
    public Plane() {
        LOGGER.fine("Вызван конструктор самолёта без параметров.");
    }

    @Override
    public String toString() {
        LOGGER.fine("Вызван метод toString() для самолёта " + model);

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

        LOGGER.info("Создан самолёт модели: " + model);
        LOGGER.fine("Инициализированы двигатель, крылья и шасси.");
    }

    // Метод: задавать маршрут
    public void setRoute(String[] route) {
        LOGGER.fine("Попытка установить маршрут самолёта " + model);

        if (route == null || route.length == 0) {
            LOGGER.warning("Устанавливается пустой маршрут для самолёта " + model);
        }

        this.route = route;

        LOGGER.info("Маршрут самолёта " + model +
                " обновлён: " + Arrays.toString(route));

        System.out.println("Диспетчер: Маршрут обновлен.");
    }

    // Метод: вывести на консоль маршрут
    public void printRoute() {
        LOGGER.fine("Вызван метод printRoute() для самолёта " + model);

        System.out.println("Текущий маршрут борта " + model +
                ": " + Arrays.toString(route));

        LOGGER.info("Маршрут самолёта " + model + " выведен на экран.");
    }

    // Метод: выполнение рейса
    public void fly() {
        LOGGER.info("Начало выполнения рейса самолёта " + model);

        try {
            System.out.println("\n--- Начинаем выполнение рейса ---");

            LOGGER.fine("Подготовка двигателя к запуску.");
            engine.start();

            LOGGER.info("Двигатель самолёта " + model + " запущен.");

            System.out.println("Взлет...");

            LOGGER.fine("Начинается уборка шасси.");
            chassis.retract();

            LOGGER.info("Шасси самолёта " + model + " убраны.");

            System.out.println("Самолет " + model +
                    " успешно летит по маршруту: " +
                    Arrays.toString(route));

            LOGGER.info("Самолёт " + model + " успешно начал полёт.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка при выполнении рейса самолёта " + model, e);
        }
    }
}
