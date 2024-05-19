package models;

public class Manager extends AbstractEmployee{
    public Manager(String name, int hiringYear) {
        super(name, "Gerente", 20000.00, hiringYear);
    }

    @Override
    public double calculateBenefits(int year, int month) {
        int serviceYears = getServiceYears(year);
        return 3000.00 * serviceYears;
    }
}
