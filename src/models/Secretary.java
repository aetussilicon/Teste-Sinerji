package models;

public class Secretary extends AbstractEmployee{
    public Secretary(String name, int hiringYear) {
        super(name, "Secretário", 7000.00, hiringYear);
    }

    @Override
    public double calculateBenefits(int year, int month) {
        int serviceYears = getServiceYears(year);
        return 1000.0 * serviceYears + 0.20 * getBaseSalary();
    }
}
