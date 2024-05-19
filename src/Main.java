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

        int year = 2022;
        int month = 4;

        Map<String, Double> totalPaid = EmployeesService.calculateTotalPaid(employees, year, month);
        System.out.println("Total pago em Abril de " + year + ":");
        for (Map.Entry<String, Double> entry : totalPaid.entrySet()) {
            System.out.println(entry.getKey() + ": R$ " + entry.getValue());
        }
    }
}