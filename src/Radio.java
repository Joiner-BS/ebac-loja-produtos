// Representa um rádio como um tipo de Produto.
public final class Radio extends Produto {

    // Cria um rádio com nome e preço fixos, sem receber parâmetros.
    public Radio() {
        // Envia os dados ao construtor de Produto: R$ 150,00.
        super("Rádio", 15_000);
    }
}