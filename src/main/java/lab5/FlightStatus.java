package lab5;

public enum FlightStatus {
    LOADING("Загрузка"),
    UNLOADING("Разгрузка"),
    REFUELING("Заправка"),
    EN_ROUTE("В пути"),
    UNDER_REPAIR("В ремонте"),
    READY_FOR_DEPARTURE("Готов к вылету"),
    REPAIR_REQUIRED("Требуется ремонт");

    private final String description;
    FlightStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
