import models.AbstractEmployee;
import models.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeesService {

    /**
     * Calcula o total recebido por uma lista de funcionários e
     * retorna o valor total pago daquele mês/ano em salários e benefícios
     *
     * @param employees Lista de funcionários.
     * @param year Ano para cálculo
     * @param month Mês para cálculo
     * @return totalPaidPerEmployee Mapa com os nomes dos funcionários e os respectivos totais pagos no mês e ano especificados.
     *
     * **/
    public static Map<String, Double> calculateTotalPaid(ArrayList<AbstractEmployee> employees, int year, int month) {
        Map<String, Double> totalPaidPerEmployee = new HashMap<>();
        for (AbstractEmployee employee : employees) {
            if (employee.getHiringYear() <= year) {
                double total = employee.getTotal(year, month);
                totalPaidPerEmployee.put(employee.getName(), total);
            }
        }
        return totalPaidPerEmployee;
    }

    /**
     * Calcula total de salários pagos a uma lista de funcionários
     * em determinado mês/ano.
     *
     */
    public static double calculateTotalSalaries(ArrayList<AbstractEmployee> employees, int year, int month) {
        double total = 0;
        for (AbstractEmployee employee : employees) {
            if (employee.getHiringYear() <= year) {
                total += employee.getBaseSalary();
            }
        }
        return total;
    }

    /**
     * Calcula o total de benefícios recebidos por uma lista de funcionários
     * em determinado mês/ano.
     *
     * Funcionários que não recebem algum benefício são ignorados
     */
    public static double calculateTotalBenefits(ArrayList<AbstractEmployee> employees, int year, int month) {
        double total = 0;
        for (AbstractEmployee employee : employees) {
            if (employee.getRole() != "Gerente") {
                total += employee.calculateBenefits(year, month);
            }
        }
        return total;
    }

    /**
     * Retorna o funcionário com maior rendimento no mês baseado em uma lista.
     *
     */
    public static AbstractEmployee employeeWithHighestSalary(ArrayList<AbstractEmployee> employees, int year, int month) {
        AbstractEmployee highest = null;
        double highestValue = 0;
        for (AbstractEmployee employee : employees) {
            double totalReceived = employee.getTotal(year, month);
            if (totalReceived > highestValue) {
                highestValue = totalReceived;
                highest = employee;
            }
        }
        return highest;
    }

    /**
     * Retorna o funcionário com o valor mais alto de benefícios em um determinado mês/ano.
     *
     * Funcionários que não recebem algum benefício são ignorados
     *
     */
    public static AbstractEmployee employeeWithHighestBenefit(ArrayList<AbstractEmployee> employees, int year, int month) {
        AbstractEmployee highestBenefit = null;
        double highestValue = 0;
        for (AbstractEmployee employee : employees) {
            if (employee.getRole() != "Gerente") {
                double totalBenefits = employee.calculateBenefits(year, month);
                if (totalBenefits > highestValue) {
                    highestValue = totalBenefits;
                    highestBenefit = employee;
                }
            }
        }
        return highestBenefit;
    }

    /**
     * Retorna o vendedor que mais vendeu em determinado mês/ano.
     */
    public static Seller sellerWithHighestSale(ArrayList<Seller> sellers, int year, int month) {
        Seller higherSeller = null;
        double highestSale = 0;
        for (Seller seller : sellers) {
            if (seller.getHiringYear() <= year) {
                double monthSales = seller.getTotalSalesInMonth(year, month);
                if (monthSales > highestSale) {
                    highestSale = monthSales;
                    higherSeller = seller;
                }
            }
        }
        return higherSeller;
    }

}
