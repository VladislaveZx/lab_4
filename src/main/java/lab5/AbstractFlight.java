package lab5;

import java.sql.SQLOutput;

public abstract class AbstractFlight implements Flight {
    private final String flightNumber;
    private String destination;
    private final String aircraftModel;

    protected FlightStatus status;
    private double fuelAmount;
    private final double equippedWeight;
    private final double averageFlightTime;

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getEquippedWeight() {
        return equippedWeight;
    }

    public double getAverageFlightTime() {
        return averageFlightTime;
    }

    public AbstractFlight(String flightNumber, String destination, String aircraftModel,
                          double equippedWeight, double averageFlightTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.aircraftModel = aircraftModel;
        this.equippedWeight = equippedWeight;
        this.averageFlightTime = averageFlightTime;
        this.status = FlightStatus.READY_FOR_DEPARTURE;
        this.fuelAmount = 0.0;
    }

    @Override
    public void refuel(double amount) {
        if (status == FlightStatus.EN_ROUTE || status == FlightStatus.UNDER_REPAIR ) {
            System.out.println("Ошибка: Заправка невозможна в текущем статусе.");
            return;
        }
        this.status = FlightStatus.REFUELING;
        this.fuelAmount += amount;
        System.out.printf("Рейс %s: Заправлено %.1f т. Текущий бак: %.1f т.\n",
                flightNumber, amount, fuelAmount);
        this.status = FlightStatus.READY_FOR_DEPARTURE;
    }

    @Override
    public void dispatch() {
        if (status == FlightStatus.READY_FOR_DEPARTURE && fuelAmount > 0) {
            this.status = FlightStatus.EN_ROUTE;
            System.out.println("Рейс " + flightNumber + " отправлен в " + destination);
        } else {
            System.out.println("Ошибка отправки рейса " + flightNumber + ".");
        }
    }

    @Override
    public void repair() {
        if (status == FlightStatus.REPAIR_REQUIRED) {
            this.status = FlightStatus.UNDER_REPAIR;
            System.out.println("Рейс " + flightNumber + " отправлен в ремонт.");
            this.status = FlightStatus.READY_FOR_DEPARTURE;
            System.out.println("Ремонт завершен.");
        }
    }

}
