package ex7;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String marca, String modelo, int ano, double kmRodados, double capacidadeCarga) {
        super(placa, marca, modelo, ano, kmRodados);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularProximaManutencao() {
        return kmRodados + 15000;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
    }

    public void exibirInformacoes(boolean detalhada) {
        exibirInformacoes();
        if (detalhada) {
            System.out.println("Histórico de Manutenções:");
            for (Manutencao m : historicoManutencoes) {
                m.exibirDetalhes();
            }
        }
    }
}