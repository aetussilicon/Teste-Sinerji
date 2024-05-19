package models;

public abstract  class AbstractEmployee {
    private String name;
    private String role;
    private double baseSalary;
    private int hiringYear;

    public AbstractEmployee(String name, String role, double baseSalary, int hiringYear) {
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.hiringYear = hiringYear;
    }

    public abstract double calculateBenefits(int year, int month);

    public double getTotal(int year, int month) {
        return getBaseSalary() + calculateBenefits(year, month);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getHiringYear() {
        return hiringYear;
    }

    public int getServiceYears(int currentYear) {
        return currentYear - hiringYear;
    }

}
