package util;

import java.util.List;

public class PriceUtils {
    public static double sumPrices(List<Double> prices) {
        double sum = 0.0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }
}
