package lab4.task1.service;

import lab4.task1.model.Plane;

public class PlaneService {
    public static void main(String[] args) {
        // Создаем объект класса Самолет
        Plane myPlane = new Plane("Airbus A320");

        // Задаем маршрут
        myPlane.setRoute(new String[]{"Moscow", "London", "Paris"});

        // Выводим маршрут на консоль
        myPlane.printRoute();

        // Вызываем метод полета
        myPlane.fly();
    }
}
