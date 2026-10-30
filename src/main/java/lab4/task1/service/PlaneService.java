
package lab4.task1.service;

import lab4.task1.model.Plane;
import lab4.task1.model.Engine;
import lab4.task1.model.Wing;
import lab4.task1.model.Chassis;

import java.util.logging.Logger;
import java.util.logging.Level;

public class PlaneService {

    private static final Logger LOGGER =
            Logger.getLogger(PlaneService.class.getName());

    public static void main(String[] args) {

        LOGGER.info("Начало работы самолёта");

        try {
            // 1. Создание самолёта
            LOGGER.info("Создание самолёта.");

            Plane myPlane = new Plane("Airbus A320");

            // 2. Установка маршрута
            LOGGER.info("Установка маршрута.");

            myPlane.setRoute(
                    new String[]{"Moscow", "London", "Paris"}
            );

            // 3. Вывод маршрута
            LOGGER.info("Вывод маршрута.");

            myPlane.printRoute();

            // 4. Демонстрация работы крыла
            LOGGER.info("Проверка информации о крыльях.");

            Wing leftWing = new Wing("Левое");
            Wing rightWing = new Wing("Правое");

            System.out.println("Левое крыло: " +
                    leftWing.getPosition());

            System.out.println("Правое крыло: " +
                    rightWing.getPosition());

            // 5. Демонстрация работы двигателя
            LOGGER.info("Проверка работы двигателя.");

            Engine engine = new Engine();
            engine.start();
            engine.stop();

            // 6. Демонстрация работы шасси
            LOGGER.info("Проверка работы шасси.");

            Chassis chassis = new Chassis();
            chassis.deploy();
            chassis.retract();

            // 7. Выполнение полёта
            LOGGER.info("Запуск демонстрации полёта.");

            myPlane.fly();

            LOGGER.info("Конец работы самолета");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка во время демонстрации работы самолёта.", e);
        }
    }
}
