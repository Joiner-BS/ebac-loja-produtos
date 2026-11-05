import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Loja {

    // Formata os valores no padrão brasileiro, como R$ 1.800,00.
    private static final NumberFormat MOEDA =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        // O catálogo reúne objetos das cinco subclasses no mesmo vetor.
        Produto[] catalogo = {
                new Televisao(), new Radio(), new Videogame(),
                new Tablet(), new Celular()
        };

        // Cada posição corresponde à mesma posição do catálogo.
        // No início, o carrinho está vazio e as quantidades são zero.
        Produto[] carrinho = new Produto[catalogo.length];
        int[] quantidades = new int[catalogo.length];

        System.out.println("Bem-vindo à nossa loja!");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                exibirMenu(catalogo);
                Integer opcao = lerInteiro(scanner, "Escolha uma opção: ");

                if (opcao == null) {
                    continue;
                }

                if (opcao == 0) {
                    break;
                }

                if (opcao < 1 || opcao > catalogo.length) {
                    System.out.println("Produto inválido. Escolha uma opção do menu.");
                    continue;
                }

                // A opção 1 do menu corresponde à posição 0 do vetor.
                int indice = opcao - 1;

                Integer quantidade;
                while (true) {
                    quantidade = lerInteiro(scanner, "Informe a quantidade: ");

                    if (quantidade == null || quantidade <= 0) {
                        System.out.println("Informe uma quantidade inteira maior que zero.");
                    } else {
                        break;
                    }
                }

                // Verifica a soma antes de guardá-la no vetor de inteiros.
                if (quantidade > Integer.MAX_VALUE - quantidades[indice]) {
                    System.out.println("A quantidade acumulada é grande demais.");
                    continue;
                }

                // Compras repetidas do mesmo produto somam na mesma posição.
                carrinho[indice] = catalogo[indice];
                quantidades[indice] += quantidade;

                System.out.println("Produto adicionado: " + carrinho[indice].getNome());
            }
        }

        exibirResumo(carrinho, quantidades);
    }

    // Apresenta os produtos e seus preços unitários.
    private static void exibirMenu(Produto[] catalogo) {
        System.out.println("\n===== PRODUTOS =====");

        for (int i = 0; i < catalogo.length; i++) {
            Produto produto = catalogo[i];

            System.out.printf("%d - %s | %s%n",
                    i + 1,
                    produto.getNome(),
                    formatarMoeda(produto.getPrecoEmCentavos()));
        }

        System.out.println("0 - Finalizar compra");
    }

    // Lê a linha inteira para rejeitar textos, decimais e entradas vazias.
    private static Integer lerInteiro(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine().trim();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            return null;
        }
    }

    // Lista somente os produtos comprados e soma seus subtotais.
    private static void exibirResumo(Produto[] carrinho, int[] quantidades) {
        System.out.println("\n===== RESUMO DA COMPRA =====");
        long totalEmCentavos = 0;

        for (int i = 0; i < carrinho.length; i++) {
            Produto produto = carrinho[i];

            if (produto == null) {
                continue;
            }

            // Converte para long antes de multiplicar, para comportar valores maiores.
            long subtotal = (long) produto.getPrecoEmCentavos() * quantidades[i];
            totalEmCentavos += subtotal;

            System.out.printf("%s | Quantidade: %d | Subtotal: %s%n",
                    produto.getNome(), quantidades[i], formatarMoeda(subtotal));
        }

        if (totalEmCentavos == 0) {
            System.out.println("Nenhum produto comprado.");
        }

        System.out.println("Total da compra: " + formatarMoeda(totalEmCentavos));
    }

    // Converte centavos em reais apenas para exibição.
    private static String formatarMoeda(long centavos) {
        return MOEDA.format(BigDecimal.valueOf(centavos, 2));
    }
}