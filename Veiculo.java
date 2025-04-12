package ex7;

import java.util.ArrayList;

public class Veiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double kmRodados;
    protected ArrayList<Manutencao> historicoManutencoes = new ArrayList<>();

    public Veiculo(String placa, String marca, String modelo, int ano, double kmRodados) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.kmRodados = kmRodados;
    }

    public Veiculo() {}

    public void adicionarManutencao(Manutencao manutencao) {
        historicoManutencoes.add(manutencao);
    }

    public void exibirInformacoes() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Km Rodados: " + kmRodados);
    }

    public double calcularProximaManutencao() {
        return kmRodados + 10000;
    }

    public ArrayList<Manutencao> getHistoricoManutencoes() {
        return historicoManutencoes;
    }

    public String getPlaca() {
        return placa;
    }
}