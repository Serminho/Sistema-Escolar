import java.util.*;

public class CadastroDisciplinas {
    private final LinkedHashSet<Disciplina> disciplinas = new LinkedHashSet<>();
    public boolean adicionarDisciplina(Disciplina d) {
        return disciplinas.add(d);
    }
    public boolean verificarDisciplina(String codigo) {
        for (Disciplina d : disciplinas)
        if (d.getCodigo().equalsIgnoreCase(codigo)) return true;
        return false;
    }

    public boolean removerDisciplina(String codigo) {
        return disciplinas.removeIf(d -> d.getCodigo().equalsIgnoreCase(codigo));
    }

    public List<Disciplina> obterTodasDisciplinasEmOrdem() {
        return new ArrayList<>(disciplinas);
    }
}
