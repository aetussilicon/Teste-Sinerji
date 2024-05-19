import models.AbstractEmployee;
import models.Manager;
import models.Secretary;
import models.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArrayList<AbstractEmployee> employees = new ArrayList<>();

        Map<String, Double> anaSales = new HashMap<>();
        anaSales.put("12/2021", 5200.0);
        anaSales.put("01/2022", 4000.0);
        anaSales.put("02/2022", 4200.0);
        anaSales.put("03/2022", 5850.0);
        anaSales.put("04/2022", 7000.0);

        Map<String, Double> joaoSales = new HashMap<>();
        joaoSales.put("12/2021", 3400.0);
        joaoSales.put("01/2022", 7700.0);
        joaoSales.put("02/2022", 5000.0);
        joaoSales.put("03/2022", 5900.0);
        joaoSales.put("04/2022", 6500.0);

        employees.add(new Secretary("Jorge Carvalho", 2018));
        employees.add(new Secretary("Maria Souza", 2015));
        employees.add(new Seller("Ana Silva", 2021, anaSales));
        employees.add(new Seller("João Mendes", 2021, joaoSales));
        employees.add(new Manager("Juliana Alves", 2017));
        employees.add(new Manager("Bento Albino", 2014));

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller("Ana Silva", 2021, anaSales));
        sellers.add(new Seller("João Mendes", 2021, joaoSales));

        int year = 2022;
        int month = 4;

        Map<String, Double> totalPaid = EmployeesService.calculateTotalPaid(employees, year, month);
        System.out.println("Total pago em Abril de " + year + ":");
        for (Map.Entry<String, Double> entry : totalPaid.entrySet()) {
            System.out.println(entry.getKey() + ": R$ " + entry.getValue());
        }

        System.out.println("-----------------------");

        double totalSalaries = EmployeesService.calculateTotalSalaries(employees, year, month);
        System.out.println("Total dos salários base em Abril de 2022: R$ " + totalSalaries);

        System.out.println("-----------------------");

        double totalBenefits = EmployeesService.calculateTotalBenefits(employees, year, month);
        System.out.println("Total dos benefícios base em Abril de 2022: R$ " + totalBenefits);

        System.out.println("-----------------------");

        AbstractEmployee highestPaidEmployee = EmployeesService.employeeWithHighestSalary(employees, year, month);
        System.out.println("Funcionário com o maior recebimento em Abril de 2022: " + highestPaidEmployee.getName());

        System.out.println("-----------------------");

        AbstractEmployee highestBenefitEmployee = EmployeesService.employeeWithHighestBenefit(employees, year, month);
        System.out.println("Funcionário com o maior benefício em Abril de 2022: " + highestBenefitEmployee.getName());

        System.out.println("-----------------------");

        Seller highestSellingSeller = EmployeesService.sellerWithHighestSale(sellers, year, month);
        System.out.println("Funcionário com a maior venda em Abril de 2022: " + highestSellingSeller.getName());
    }
}