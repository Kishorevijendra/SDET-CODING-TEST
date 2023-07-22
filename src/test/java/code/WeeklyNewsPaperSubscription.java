package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeeklyNewsPaperSubscription {
    private static final String[] NEWSPAPERS = {"TOI", "Hindu", "ET", "BM", "HT"};
    private static final double[][] PRICES = {
            {3, 3, 3, 3, 3, 5, 6},
            {2.5, 2.5, 2.5, 2.5, 2.5, 4, 4},
            {4, 4, 4, 4, 4, 4, 10},
            {1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5},
            {2, 2, 2, 2, 2, 4, 4}
    };
    private static double budget;

    public static void newspaperCombinations(double budget) {
        int n = NEWSPAPERS.length;
        List<List<String>> combinations = new ArrayList<>();

        for (int i = 1; i < (1 << n); i++) {
            List<String> combination = new ArrayList<>();
            double totalCost = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    double minPrice = Double.MAX_VALUE;
                    for (int day = 0; day < 7; day++) {
                        minPrice = Math.min(minPrice, PRICES[j][day]);
                    }
                    totalCost += minPrice;
                    combination.add(NEWSPAPERS[j]);
                }
            }

            if (totalCost <= budget) {
                combinations.add(combination);
            }
        }

        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your budget :");
        budget = scanner.nextDouble();
        System.out.println("Possible combinations for the given budget are :");
        newspaperCombinations(budget);
    }
}

