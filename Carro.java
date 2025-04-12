package ex7;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String placa, String marca, String modelo, int ano, double kmRodados, int quantidadePortas) {
        super(placa, marca, modelo, ano, kmRodados);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public double calcularProximaManutencao() {
        return kmRodados + 10000;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Portas: " + quantidadePortas);
    }

    public void exibirInformacoes(boolean detalhada) {
        exibirInformacoes();
        if (detalhada) {
            System.out.println("Historico de Manutencoes:");
            for (Manutencao m : historicoManutencoes) {
                m.exibirDetalhes();
            }
        }
    }
}