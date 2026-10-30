
package lab4.task1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chassis {

    private static final Logger LOGGER =
            Logger.getLogger(Chassis.class.getName());

    // Уборка шасси
    public void retract() {
        LOGGER.fine("Начало процедуры уборки шасси.");

        try {
            System.out.println("Шасси убраны.");

            LOGGER.info("Шасси успешно убраны.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка при уборке шасси.", e);
            throw e;
        }
    }

    // Выпуск шасси
    public void deploy() {
        LOGGER.fine("Начало процедуры выпуска шасси.");

        try {
            System.out.println("Шасси выпущены.");

            LOGGER.info("Шасси успешно выпущены.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка при выпуске шасси.", e);
            throw e;
        }
    }
}
