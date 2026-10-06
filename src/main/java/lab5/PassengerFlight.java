package lab5;

public class PassengerFlight extends AbstractFlight implements PassengerHandling {
    private int passengerCount;
    private final int maxCapacity;

    public PassengerFlight(String flightNumber, String destination, String aircraftModel,
                           double equippedWeight, double averageFlightTime, int maxCapacity) {
        super(flightNumber, destination, aircraftModel, equippedWeight, averageFlightTime);
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void load() {
        this.status = FlightStatus.LOADING;
        System.out.println("Посадка пассажиров на рейс " + getFlightNumber() + "...");
        this.passengerCount = maxCapacity;
        this.status = FlightStatus.READY_FOR_DEPARTURE;
    }

    @Override
    public void unload() {
        this.status = FlightStatus.UNLOADING;
        System.out.println("Высадка пассажиров с рейса " + getFlightNumber() + "...");
        this.passengerCount = 0;
        this.status = FlightStatus.READY_FOR_DEPARTURE;
    }

    @Override
    public void serveInFlightMeals() {
        if (getStatus() == FlightStatus.EN_ROUTE) {
            System.out.println("Стюардессы раздают питание пассажирам.");
        } else {
            System.out.println("Питание подается только во время полета.");
        }
    }

    @Override
    public int getPassengerCount() {
        return passengerCount;
    }


}