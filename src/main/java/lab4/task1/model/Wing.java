
package lab4.task1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Wing {
    private String position;

    private static final Logger LOGGER =
            Logger.getLogger(Wing.class.getName());

    // Конструктор
    public Wing(String position) {
        LOGGER.fine("Начало создания крыла.");

        if (position == null || position.isEmpty()) {
            LOGGER.warning("Позиция крыла не указана!");
        }

        this.position = position;

        LOGGER.info("Создано крыло: " + position);
    }

    // Получение позиции крыла
    public String getPosition() {
        LOGGER.fine("Запрошена позиция крыла: " + position);

        try {
            if (position == null) {
                LOGGER.severe("Ошибка: позиция крыла отсутствует!");
                throw new IllegalStateException(
                        "Позиция крыла не задана."
                );
            }

            LOGGER.info("Позиция крыла успешно получена: " + position);

            return position;

        } catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE,
                    "Не удалось получить позицию крыла.", e);
            throw e;
        }
    }
}
