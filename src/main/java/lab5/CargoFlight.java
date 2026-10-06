package lab5;

public class CargoFlight extends AbstractFlight implements CargoHandling {
    private final double cargoValue;
    private final boolean isFragile;
    private final String cargoDescription;

    public CargoFlight(String flightNumber, String destination, String aircraftModel,
                       double equippedWeight, double averageFlightTime,
                       String cargoDescription, double cargoValue, boolean isFragile) {
        super(flightNumber, destination, aircraftModel, equippedWeight, averageFlightTime);
        this.cargoDescription = cargoDescription;
        this.cargoValue = cargoValue;
        this.isFragile = isFragile;
    }

    @Override
    public void load() {
        this.status = FlightStatus.LOADING;
        System.out.println("Загрузка груза: " + cargoDescription);
        if (isFragile) {
            System.out.println("Внимание! Груз хрупкий. Требуется осторожность.");
        }
        this.status = FlightStatus.READY_FOR_DEPARTURE;
    }

    @Override
    public void unload() {
        this.status = FlightStatus.UNLOADING;
        System.out.println("Разгрузка грузового рейса " + getFlightNumber() + ".");
        this.status = FlightStatus.READY_FOR_DEPARTURE;
    }

    @Override
    public void checkTemperatureConditions() {
        System.out.println("Температурный режим в грузовом отсеке в норме.");
    }

    @Override
    public double getCargoValue() { return cargoValue; }

    @Override
    public boolean isFragile() { return isFragile; }
}
