package ex7;

public class Manutencao {
    private String data;
    private String descricao;
    private double kmRealizada;

    public Manutencao(String data, String descricao, double kmRealizada) {
        this.data = data;
        this.descricao = descricao;
        this.kmRealizada = kmRealizada;
    }

    public Manutencao() {}

    public void exibirDetalhes() {
        System.out.println("Data: " + data + " | Descrição: " + descricao + " | Km: " + kmRealizada);
    }
}