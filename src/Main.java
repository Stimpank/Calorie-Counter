import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command <= 0){
                System.out.println("Ошибка! Минимальное значение - 1");
            }else if (command == 1){
                stepTracker.saveStepsInDay();
            }else if (command == 2){
                stepTracker.printStatisticForTheMonth();
            }else if (command == 3){
                stepTracker.changeGoalBySteps();
            }else if (command == 4){
                System.out.println("Программа завершенна");
                break;
            }else{
                System.out.println("Ошибка! Максимальное значение - 4");
            }
        }
    }

    private static void printMenu(){
        System.out.println("1. Ввести количество шагов за день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выход из приложения");
    }
}