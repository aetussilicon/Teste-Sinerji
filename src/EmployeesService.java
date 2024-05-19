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
}
