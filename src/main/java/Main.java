
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Auto> autoList = new ArrayList<>(3); // создаем список для 3-х объектов класса Auto

        for (int i = 1; i <= 3; i++) { // создаем цикл для заполнения списка autoList значениями с помощью клавиатуры

            String inputAuto;
            int inputSpeed;

            System.out.println("Введите название автомобиля № " + i +":");
            inputAuto = scanner.nextLine(); // считываем с клавиатуры название автомобиля

            System.out.println("Введите скорость автомобиля № " + i + ":");
            while (true) {
                if (scanner.hasNextInt()) {
                    inputSpeed = scanner.nextInt(); // считываем с клавиатуры скорость автомобиля
                    scanner.nextLine();
                    if (inputSpeed > 0 && inputSpeed <= 250) { // проверяем соответствие введенной с клавиатуры скорости требуемому диапазону
                        break;
                    } else {
                        System.out.println("Неправильное значение скорости! Скорость должна быть в диапазоне от 0 до 250! Введите скорость автомобиля № " + i + " еще раз:");
                    }
                } else {
                    System.out.println("Неправильное значение скорости! Скорость должна быть целым числом! Введите скорость автомобиля № " + i + " еще раз:");
                    scanner.next();
                }
            }

            autoList.add(new Auto(inputAuto, inputSpeed)); // заполняем список autoList объектами класса Auto в соответствии с введенными с клавиатуры названием и скоростью автомобиля

        }

        scanner.close();

        Race.getLider(autoList); //Вызываем метод из класса Race, выводящий в консоль победителя
    }
}

// создаем класс для создания объектов Auto (автомобилей)
class Auto {
    String automerk;
    int speed;

    Auto(String automerk, int speed) {
        this.automerk = automerk;
        this.speed = speed;
    }
}

class Race {
    public static void getLider(ArrayList<Auto> liderList) {
        int max = 0;
        for(int i= 0; i < liderList.size(); i++) { //создаем цикл для определения максимальной скорости
            if (liderList.get(i).speed > max) {
                max = liderList.get(i).speed;
            }
        }

        Auto lider;
        for(int i = 0; i < liderList.size(); i++) { //создаем цикл для определения названия самого быстрого автомобля по максимальной скорости и вывода сообщения в консоль
            if (liderList.get(i).speed == max) {
                lider = liderList.get(i);
                String liderAutomerk = lider.automerk;
                System.out.println("Самая быстрая машина: " + liderAutomerk + ".");
            }
        }
    }
}