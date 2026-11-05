// Representa um videogame como um tipo de Produto.
public final class Videogame extends Produto {

    // Cria um videogame com nome e preço fixos, sem receber parâmetros.
    public Videogame() {
        // Envia os dados ao construtor de Produto: R$ 2.500,00.
        super("Videogame", 250_000);
    }
}