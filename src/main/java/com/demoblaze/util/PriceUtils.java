package com.demoblaze.util;

import java.util.List;

public class PriceUtils {
    public static String sumPrices(List<Double> prices) {
        double sum = 0.0;
        for (double price : prices) {
            sum += price;
        }
        return String.format("%.0f", sum);
    }

    public static double cleanPriceTxt(String text) {
        String price = text.split("\\s+")[0];
        price = price.replace("$", "");
        return Double.parseDouble(price);
    }
}
