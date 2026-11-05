// Reúne os atributos e métodos comuns a todos os produtos da loja.
// Por ser abstrata, esta classe não permite criar um objeto com new Produto().
// Os objetos são criados pelas subclasses, como Televisao e Radio.
public abstract class Produto {

    // private: apenas a própria classe acessa diretamente estes atributos.
    // final: depois de definidos no construtor, seus valores não mudam.
    private final String nome;
    private final int precoEmCentavos;

    // O construtor recebe o nome e o preço fixo de cada tipo de produto.
    // As subclasses podem chamá-lo com super(nome, precoEmCentavos).
    protected Produto(String nome, int precoEmCentavos) {
        // À esquerda, this.nome é o atributo do objeto.
        // À direita, nome é o valor recebido como parâmetro.
        this.nome = nome;

        // Guarda o preço em centavos para fazer as somas com números inteiros.
        // Exemplo: 180_000 centavos representam R$ 1.800,00.
        this.precoEmCentavos = precoEmCentavos;
    }

    // Getter: permite que outras classes consultem o nome do produto.
    public String getNome() {
        return nome;
    }

    // Getter: retorna o preço de uma unidade em centavos.
    // A classe Loja usará esse valor para calcular o subtotal da compra.
    public int getPrecoEmCentavos() {
        return precoEmCentavos;
    }
}