package lab4.task2;

import lab4.task2.model.salad.Salad;
import lab4.task2.model.vegitable.FruitVegetable;
import lab4.task2.model.vegitable.RootVegetable;
import lab4.task2.service.ChefService;

import java.util.Scanner;

public class Main {
    // Хранилище для всех созданных салатов (максимум 10 для примера)
    private static final Salad[] salads = new Salad[10];
    private static int saladCount = 0; // Счетчик текущего количества салатов

    public static void main(String[] args) {
        ChefService chef = new ChefService();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== МЕНЮ РЕСТОРАНА ===");
            System.out.println("1. Создать новый салат");
            System.out.println("2. Показать список всех салатов");
            System.out.println("3. Добавить овощ в салат");
            System.out.println("4. Приготовить салат");
            System.out.println("5. Посчитать калорийность салата");
            System.out.println("6. Отсортировать овощи по весу в салате");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createNewSalad(scanner);
                    break;
                case "2":
                    showAllSalads();
                    break;
                case "3":
                    addVegetableToSaladMenu(scanner);
                    break;
                case "4":
                    Salad saladToMake = selectSalad(scanner);
                    if (saladToMake != null) chef.makeSalad(saladToMake);
                    break;
                case "5":
                    Salad saladToCalc = selectSalad(scanner);
                    if (saladToCalc != null) {
                        System.out.printf("Калорийность салата '%s': %.1f ккал\n",
                                saladToCalc.getName(), chef.calculateTotalCalories(saladToCalc));
                    }
                    break;
                case "6":
                    Salad saladToSort = selectSalad(scanner);
                    if (saladToSort != null) chef.sortVegetablesByWeight(saladToSort);
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Работа ресторана завершена.");
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
            }
        }
        scanner.close();
    }

    // --- Приватные методы для чистой организации консольного меню ---

    private static void createNewSalad(Scanner scanner) {
        if (saladCount >= salads.length) {
            System.out.println("Ошибка: Меню переполнено, невозможно добавить новый салат.");
            return;
        }

        System.out.print("Введите название нового салата: ");
        String name = scanner.nextLine();

        System.out.print("Введите максимальное количество ингредиентов: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        salads[saladCount] = new Salad(name, capacity);
        saladCount++;
        System.out.println("Салат '" + name + "' успешно добавлен в меню!");
    }

    private static void showAllSalads() {
        if (saladCount == 0) {
            System.out.println("Меню пока пусто. Создайте хотя бы один салат.");
            return;
        }
        System.out.println("--- Список салатов ---");
        for (int i = 0; i < saladCount; i++) {
            System.out.println((i + 1) + ". " + salads[i].getName());
        }
    }

    private static Salad selectSalad(Scanner scanner) {
        if (saladCount == 0) {
            System.out.println("Нет доступных салатов. Сначала создайте салат (Пункт 1).");
            return null;
        }

        showAllSalads();
        System.out.print("Введите номер салата: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < saladCount) {
            return salads[index];
        } else {
            System.out.println("Ошибка: Салата с таким номером нет.");
            return null;
        }
    }

    private static void addVegetableToSaladMenu(Scanner scanner) {
        Salad targetSalad = selectSalad(scanner);
        if (targetSalad == null) return;

        System.out.println("\nКакой тип овоща добавить в '" + targetSalad.getName() + "'?");
        System.out.println("1 - Корнеплод (морковь, свекла)");
        System.out.println("2 - Плодовый овощ (огурец, помидор)");
        System.out.print("Ваш выбор: ");
        String type = scanner.nextLine();

        System.out.print("Название овоща: ");
        String name = scanner.nextLine();

        System.out.print("Калорийность на 100г: ");
        double calories = Double.parseDouble(scanner.nextLine());

        System.out.print("Вес порции (в граммах): ");
        double weight = Double.parseDouble(scanner.nextLine());

        if (type.equals("1")) {
            System.out.print("Нужно чистить от кожуры? (true/false): ");
            boolean requiresPeeling = Boolean.parseBoolean(scanner.nextLine());
            targetSalad.addVegetable(new RootVegetable(name, calories, weight, requiresPeeling));
        } else if (type.equals("2")) {
            System.out.print("Удалять семена? (true/false): ");
            boolean hasSeeds = Boolean.parseBoolean(scanner.nextLine());
            targetSalad.addVegetable(new FruitVegetable(name, calories, weight, hasSeeds));
        } else {
            System.out.println("Ошибка: неверный тип овоща.");
        }
    }
}