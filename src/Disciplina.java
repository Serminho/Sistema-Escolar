public class Disciplina {
    private final String codigo;
    private final String nome;

    Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "| " + codigo + " - " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Disciplina)) {
            return false;
        }
        Disciplina d = (Disciplina) o;
        return codigo.equalsIgnoreCase(d.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.toLowerCase().hashCode();
    }

}
