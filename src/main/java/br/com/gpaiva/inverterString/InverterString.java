package br.com.gpaiva.inverterString;

public class InverterString {
    public static void main(String[] args) {
        // Define a string original
        String original = "Exemplo de string";

        // Chama o método inverterString para inverter a string original
        String invertida = inverterString(original);

        // Exibe a string original e a string invertida
        System.out.println("String original: " + original);
        System.out.println("String invertida: " + invertida);
    }

    // Método para inverter uma string
    public static String inverterString(String str) {
        // Converte a string em um array de caracteres
        char[] caracteres = str.toCharArray();

        // Define os índices de início e fim
        int inicio = 0;
        int fim = caracteres.length - 1;

        // Loop para trocar os caracteres de posição até o meio da string
        while (inicio < fim) {
            // Troca os caracteres nas posições 'inicio' e 'fim'
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            // Move os índices para o próximo par de caracteres
            inicio++;
            fim--;
        }

        // Converte o array de caracteres de volta para uma string e retorna
        return new String(caracteres);
    }
}