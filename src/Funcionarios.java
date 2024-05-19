public abstract  class Funcionarios {
    private String nome;
    private String cargo;
    private double salarioBase;
    private int anoContratacao;

    public Funcionarios(String nome, String cargo, double salarioBase, int anoContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.anoContratacao = anoContratacao;
    }

    public abstract double calculateSalary(int ano, int mes);
    public abstract double calculateBenefits(int ano, int mes);

    public double getTotal(int ano, int mes) {
        return calculateSalary(ano, mes) + calculateBenefits(ano, mes);
    }

    public String getNome() {
        return nome;
    }

}
