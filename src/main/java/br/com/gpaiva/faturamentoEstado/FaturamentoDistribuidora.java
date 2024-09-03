package br.com.gpaiva.faturamentoEstado;

import java.util.List;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        // Cria uma lista de objetos FaturamentoEstado com os valores fornecidos
        List<FaturamentoEstado> faturamentoEstados = List.of(
                new FaturamentoEstado("SP", 67836.43),
                new FaturamentoEstado("RJ", 36678.66),
                new FaturamentoEstado("MG", 29229.88),
                new FaturamentoEstado("ES", 27165.48),
                new FaturamentoEstado("Outros", 19849.53)
        );

        // Calcula o faturamento total somando os valores de todos os estados
        double faturamentoTotal = faturamentoEstados.stream().mapToDouble(FaturamentoEstado::getValor).sum();

        // Para cada estado, calcula o percentual de representação no faturamento total e imprime o resultado
        faturamentoEstados.forEach(fe -> {
            double percentual = (fe.getValor() / faturamentoTotal) * 100;
            System.out.printf("Estado: %s - Percentual: %.2f%%%n", fe.getEstado(), percentual);
        });
    }
}