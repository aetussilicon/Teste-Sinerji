package models;

import java.util.Map;

public class Seller extends AbstractEmployee {
    private Map<String, Double> sales;

    public Seller(String name, int hiringYear, Map<String, Double> sales) {
        super(name, "Vendedor", 12000.00, hiringYear);
        this.sales = sales;
    }

    @Override
    public double calculateBenefits(int year, int month) {
        int serviceYears = getServiceYears(year);
        double totalSales = sales.getOrDefault(month + "/" + year, 0.0);
        return 1800.00 * serviceYears + 0.30 * totalSales;
    }

    public double getTotalSalesInMonth(int year, int month) {
        String key = String.format("%02d/%d", month, year);
        return sales.getOrDefault(key, 0.0);
    }
}
