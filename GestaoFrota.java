package ex7;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoFrota {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        System.out.println("Sistema de gestao de frota.");

        while (opcao != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Novo Ve�culo");
            System.out.println("2. Listar Veiculos");
            System.out.println("3. Registrar Manutencao");
            System.out.println("4. Consultar Histarico de Manutencao");
            System.out.println("5. Exibir Proxima Manutencao");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                System.out.print("Tipo (Carro/Caminhao): ");
                String tipo = teclado.nextLine();

                System.out.print("Placa: ");
                String placa = teclado.nextLine();
                System.out.print("Marca: ");
                String marca = teclado.nextLine();
                System.out.print("Modelo: ");
                String modelo = teclado.nextLine();
                System.out.print("Ano: ");
                int ano = teclado.nextInt();
                System.out.print("Km Rodados: ");
                double km = teclado.nextDouble();

                if (tipo.equalsIgnoreCase("Carro")) {
                    System.out.print("Quantidade de portas: ");
                    int portas = teclado.nextInt();
                    veiculos.add(new Carro(placa, marca, modelo, ano, km, portas));
                } else if (tipo.equalsIgnoreCase("Caminhao")) {
                    System.out.print("Capacidade de carga (ton): ");
                    double carga = teclado.nextDouble();
                    veiculos.add(new Caminhao(placa, marca, modelo, ano, km, carga));
                } else {
                    System.out.println("Tipo invalido.");
                }

            } else if (opcao == 2) {
                for (Veiculo v : veiculos) {
                    v.exibirInformacoes();
                }

            } else if (opcao == 3) {
                System.out.print("Placa do veiculo: ");
                String placaBusca = teclado.nextLine();
                Veiculo veiculoManut = buscarVeiculoPorPlaca(veiculos, placaBusca);

                if (veiculoManut != null) {
                    System.out.print("Data da manutencao: ");
                    String data = teclado.nextLine();
                    System.out.print("Descricao: ");
                    String desc = teclado.nextLine();
                    System.out.print("Km da manutencao: ");
                    double kmManut = teclado.nextDouble();

                    veiculoManut.adicionarManutencao(new Manutencao(data, desc, kmManut));
                    System.out.println("Manutencao registrada com sucesso.");
                } else {
                    System.out.println("Veiculo nao encontrado.");
                }

            } else if (opcao == 4) {
                System.out.print("Placa do veiculo: ");
                String placaHist = teclado.nextLine();
                Veiculo vHist = buscarVeiculoPorPlaca(veiculos, placaHist);

                if (vHist != null) {
                    System.out.println("Historico de Manutencoes:");
                    for (Manutencao m : vHist.getHistoricoManutencoes()) {
                        m.exibirDetalhes();
                    }
                } else {
                    System.out.println("Veiculo nao encontrado.");
                }

            } else if (opcao == 5) {
                System.out.print("Placa do veiculo: ");
                String placaProx = teclado.nextLine();
                Veiculo vProx = buscarVeiculoPorPlaca(veiculos, placaProx);

                if (vProx != null) {
                    double proxima = vProx.calcularProximaManutencao();
                    System.out.println("Proxima manutencao recomendada aos " + proxima + " km.");
                } else {
                    System.out.println("Veiculo nao encontrado.");
                }

            } else if (opcao == 6) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        teclado.close();
    }

    public static Veiculo buscarVeiculoPorPlaca(ArrayList<Veiculo> lista, String placa) {
        for (Veiculo v : lista) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}