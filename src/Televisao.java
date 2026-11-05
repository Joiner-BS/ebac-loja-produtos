// Representa uma televisão. Com extends, herda os métodos públicos de Produto.
// O modificador final impede que outra classe herde de Televisao.
public final class Televisao extends Produto {

    // Construtor sem parâmetros: o nome e o preço já são definidos pela classe.
    public Televisao() {
        // Chama o construtor de Produto para guardar o nome e o preço.
        // 180_000 centavos equivalem a R$ 1.800,00.
        super("Televisão", 180_000);
    }
}