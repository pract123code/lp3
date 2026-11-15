
import java.util.*;

public class k{

    public static void main(String[] args) {

        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};

        int capacity = 50;
        double totalProfit = 0;

        double[] ratio = new double[profit.length];

        // Calculate profit/weight ratio
        for (int i = 0; i < profit.length; i++) {
            ratio[i] = (double) profit[i] / weight[i];
        }

        // Sort items in descending order of ratio
        for (int i = 0; i < ratio.length; i++) {
            for (int j = i + 1; j < ratio.length; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;

                    t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;
                }
            }
        }

        // Select items greedily
        for (int i = 0; i < profit.length; i++) {

            if (capacity >= weight[i]) {

                capacity = capacity - weight[i];
                totalProfit = totalProfit + profit[i];

            } else {

                totalProfit = totalProfit +
                    ratio[i] * capacity;

                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}
