package ru.geekbrains.ageev.hw1_7;

import java.util.Scanner;

public class HomeWork1_7 {

    public static void main(String[] args) {

        // Для чтения значения, на которое увеличиваем корм в тарелке
        Scanner scanner = new Scanner(System.in);

        Cat cat = new Cat("Барсик", 15, false);
        Plate plate = new Plate(20);
        plate.info();
        cat.eat(plate);
        plate.info();

        // Создали масси котов
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Персик", 10, false);
        cats[1] = new Cat("Пушок", 20, false);
        cats[2] = new Cat("Марсик", 15, false);
        cats[3] = new Cat("Кексик", 18, false);

        // Кормушка. Здесь пробегаемся по массиву котов и просим всех покушать
        // Если положить корма не достаточно, чтобы накормить очередного кота, то по циклу переходим к следующему коту, а предыдущий остается голодным
        // Возможно здесь нужно вводить do-while
        for (Cat c : cats) {
            if (plate.getFood() >= c.getAppetite()) {
                c.eat(plate);
                plate.info();
            }
            else if (plate.getFood() < c.getAppetite()) {
                System.out.println("Добавьте еду в тарелку: ");
                int a = scanner.nextInt();
                int sum = a + plate.getFood();
                if (a > 0 && sum < c.getAppetite()){
                    plate.setFood(sum);
                    System.out.println("Добавьте корма");
                }
                else if (sum >= c.getAppetite()){
                    plate.setFood(sum);
                    c.eat(plate);
                    plate.info();
                }
                else {
                    break;
                }
            }
        }

        // Выводим информацию в консоль о сытости котов и остаток корма в тарелке
        System.out.println("==============================================");
        System.out.println("Итог кормления котов:");
        System.out.println("==============================================");
        for (Cat c : cats) {
            c.checkFulness();
        }
        plate.info();
    }
}
