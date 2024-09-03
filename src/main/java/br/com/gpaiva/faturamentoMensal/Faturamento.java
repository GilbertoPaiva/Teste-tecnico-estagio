package br.com.gpaiva.faturamentoMensal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

public class Faturamento {

    public static void main(String[] args) {
        try {
            // Ler o arquivo JSON
            ObjectMapper mapper = new ObjectMapper();
            List<FaturamentoDia> faturamentoDiario = mapper.readValue(new File("src/main/java/br/com/gpaiva/faturamentoMensal/dados.json"), new TypeReference<List<FaturamentoDia>>() {});

            // Filtrar os dias sem faturamento
            List<FaturamentoDia> diasComFaturamento = faturamentoDiario.stream()
                    .filter(f -> f.getValor() > 0)
                    .toList();

            // Calcular o menor e o maior valor de faturamento e os dias correspondentes
            double menorFaturamento = diasComFaturamento.stream().mapToDouble(FaturamentoDia::getValor).min().orElse(0.0);
            double maiorFaturamento = diasComFaturamento.stream().mapToDouble(FaturamentoDia::getValor).max().orElse(0.0);
            int diaMenorFaturamento = faturamentoDiario.stream()
                    .filter(f -> f.getValor() == menorFaturamento)
                    .findFirst()
                    .map(FaturamentoDia::getDia)
                    .orElse(-1);
            int diaMaiorFaturamento = faturamentoDiario.stream()
                    .filter(f -> f.getValor() == maiorFaturamento)
                    .findFirst()
                    .map(FaturamentoDia::getDia)
                    .orElse(-1);

            // Calcular a média de faturamento
            OptionalDouble mediaOptional = diasComFaturamento.stream().mapToDouble(FaturamentoDia::getValor).average();
            double mediaFaturamento = mediaOptional.orElse(0.0);

            // Contar o número de dias com faturamento superior à média e listar esses dias
            long diasAcimaDaMedia = diasComFaturamento.stream().filter(f -> f.getValor() > mediaFaturamento).count();
            List<Integer> diasAcimaDaMediaList = faturamentoDiario.stream()
                    .filter(f -> f.getValor() > mediaFaturamento)
                    .map(FaturamentoDia::getDia)
                    .toList();

            // Exibir os resultados
            System.out.println("Menor valor de faturamento: " + menorFaturamento + " no dia " + diaMenorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento + " no dia " + diaMaiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMediaList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}