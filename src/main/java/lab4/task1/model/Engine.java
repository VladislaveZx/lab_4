
package lab4.task1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Engine {

    private static final Logger LOGGER =
            Logger.getLogger(Engine.class.getName());

    // Запуск двигателя
    public void start() {
        LOGGER.fine("Начало процедуры запуска двигателя.");

        try {
            System.out.println("Двигатель запущен.");

            LOGGER.info("Двигатель успешно запущен.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка при запуске двигателя.", e);
            throw e;
        }
    }

    // Остановка двигателя
    public void stop() {
        LOGGER.fine("Начало процедуры остановки двигателя.");

        try {
            System.out.println("Двигатель остановлен.");

            LOGGER.info("Двигатель успешно остановлен.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка при остановке двигателя.", e);
            throw e;
        }
    }
}
