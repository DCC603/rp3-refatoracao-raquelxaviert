public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(char tipoChar, double valor) {
        this.tipo = TipoOperacao.fromCodigo(tipoChar);
        this.valor = valor;
    }

    public String getTipo() {
        return tipo != null ? tipo.getDescricao() : null;
    }

    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
