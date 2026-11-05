// Representa um celular como um tipo de Produto.
public final class Celular extends Produto {

    // Cria um celular com nome e preço fixos, sem receber parâmetros.
    public Celular() {
        // Envia os dados ao construtor de Produto: R$ 1.600,00.
        super("Celular", 160_000);
    }
}