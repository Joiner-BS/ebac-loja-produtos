// Representa um tablet como um tipo de Produto.
public final class Tablet extends Produto {

    // Cria um tablet com nome e preço fixos, sem receber parâmetros.
    public Tablet() {
        // Envia os dados ao construtor de Produto: R$ 1.200,00.
        super("Tablet", 120_000);
    }
}
