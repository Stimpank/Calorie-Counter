import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);

    int[][] monthData;
    int goalByStep = 10000;
    int month;
    int day;
    public StepTracker(){
        monthData = new int[12][30];
    }
    Converter  converter = new Converter();


    void saveStepsInDay(){

        int steps;

        while (true){
            System.out.println("Введите месяц за который хотите ввести значение: \n 1-Янв, 2-Фев, 3-Мар," +
                            " 4-Апр, 5-Май, 6-Июн, 7-Июл, 8-Авг, 9-Сен, 10-Окт, 11-Ноя, 12-Дек");
            month = scanner.nextInt();
            if (month <= 0){
                System.out.println("Ошибка! Минимальное значение - 1");
            }else if (month > 12){
                System.out.println("Ошибка! Максимальное значение - 12");
            }else{
                break;
            }
        }while (true){
            System.out.println("Введите день за который хотите ввести значение: ");
            day = scanner.nextInt();
            if (day <= 0){
                System.out.println("Ошибка! Минимальное значение - 1");
            } else if (day > 30){
                System.out.println("Ошибка! Максимальное значение - 30");
            }else{
                break;
            }
        }while (true){
            System.out.println("Введите количество шагов которые хотите сохранить: ");
            steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Ошибка! Минимальное значение - 0");
            }else{
                break;
            }
        }
        monthData[(month - 1)][(day - 1)] = monthData[(month - 1)][(day - 1)] + steps;
        System.out.println("Сохраненно! В " + month + " месяце" + ", за " + day + " день, было пройденно: "
                + monthData[(month - 1)][(day - 1)] + " шагов.\n");
    }

    void printStatisticForTheMonth(){

        int sumSteps = 0;

        while (true){
            System.out.println("Введите месяц за который хотите получить значение: \n 1-Янв, 2-Фев, 3-Мар," +
                    " 4-Апр, 5-Май, 6-Июн, 7-Июл, 8-Авг, 9-Сен, 10-Окт, 11-Ноя, 12-Дек");
            month = scanner.nextInt();
            if (month <= 0){
                System.out.println("Ошибка! Минимальное значение - 1");
            }else if (month > 12){
                System.out.println("Ошибка! Максимальное значение - 12");
            }else{
                break;
            }
        }

        for (int i = 0; i < monthData[(month - 1)].length; i++) {
            System.out.println(month + " месяц, " + (i + 1) + " день, было пройденно: "
                    + monthData[(month - 1)][i] + " шагов.");
            sumSteps = sumSteps + monthData[(month - 1)][i];

        }

        System.out.println("\nЗа этот месяц было пройдено: " + sumSteps + " шагов.");
        System.out.println("Среднее количество шагов за месяц: " + converter.getAverageSteps(sumSteps));
        System.out.println("За этот месяц было пройдено: " + converter.getDistance(sumSteps) + " км");
        System.out.println("За этот месяц было потрачено: " + converter.getKilocalories(sumSteps) + " ккал.");
        System.out.println("Лучшая серия дней: " + getBestSeries(month) + "\n");
    }


    int getBestSeries(int month){

        int bestSeries = 0;
        int currentSeries = 0;

        for (int i = 0; i < monthData[(month - 1)].length; i++){
            if (monthData[(month - 1)][i] >= goalByStep){
                currentSeries++;
            }else if (monthData[(month - 1)][i] < goalByStep){
                if (currentSeries >= bestSeries){
                    bestSeries = currentSeries;
                    currentSeries = 0;
                }
            }
        }
        return bestSeries;
    }

    void changeGoalBySteps(){
        while (true){
            System.out.println("Введите количество шагов которые хотите сохранить как вашу цель: ");
            goalByStep = scanner.nextInt();
            if (goalByStep < 0) {
                System.out.println("Ошибка! Минимальное значение - 0");
            }else{
                break;
            }
        }
    }
}
