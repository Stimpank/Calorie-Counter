public class Converter {

public Converter(){}


double getDistance(int sumSteps){
    double distance = sumSteps * 75;
    distance = distance / 100000;
    return distance;
}

int getKilocalories(int sumSteps){
    int calories;
    calories = sumSteps * 50;
    int kilocalories;
    kilocalories = calories / 1000;
    return kilocalories;
}

int getAverageSteps(int sumSteps){
    int averageSteps;
    averageSteps = sumSteps / 30;
    return averageSteps;
}

}
