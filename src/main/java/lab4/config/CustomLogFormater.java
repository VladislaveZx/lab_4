package lab4.config;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomLogFormater extends Formatter {
    @Override
    public String format(LogRecord record) {
        String level;

        if (record.getLevel() == Level.FINE) {
            level = "DEBUG";
        } else if (record.getLevel() == Level.INFO) {
            level = "INFO";
        } else if (record.getLevel() == Level.WARNING) {
            level = "WARN";
        } else if (record.getLevel() == Level.SEVERE) {
            level = "ERROR";
        } else {
            level = record.getLevel().getName();
        }

        return String.format(
                "%s: %s%n",
                level,
                formatMessage(record)
        );
    }
}
