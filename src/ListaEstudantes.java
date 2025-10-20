import java.util.*;

public class ListaEstudantes {
    private final List<Estudante> estudantes = new ArrayList<>();
    private final Map<Integer, Integer> idParaIndice = new HashMap<>();

    public void adicionarEstudante(Estudante e) {
        idParaIndice.put(e.getId(), estudantes.size());
        estudantes.add(e);
    }

    public boolean removerEstudantePorId(int id) {
        Integer idx = idParaIndice.remove(id);
        if (idx == null) return false;
        int ultimoIndex = estudantes.size() - 1;
        if (idx != ultimoIndex) {
            Estudante ultimo = estudantes.get(ultimoIndex);
            estudantes.set(idx, ultimo);
            idParaIndice.put(ultimo.getId(), idx);
        }
        estudantes.remove(ultimoIndex);
        return true;
    }

    public Estudante obterEstudantePorIndice(int indice) {
        if (indice < 0 || indice >= estudantes.size()) {
            return null;
        }
        return estudantes.get(indice);
    }
    public Estudante obterPorId(int id) {
        Integer idx = idParaIndice.get(id);
        return idx == null ? null : estudantes.get(idx);
    }

    public List<Estudante> buscarEstudantesPorNome(String substring) {
        String minusc = substring.toLowerCase();
        List<Estudante> resp = new ArrayList<>();
        for (Estudante e : estudantes)
        if (e.getNome().toLowerCase().contains(minusc)) resp.add(e);
        return resp;
    }

    public void ordenarEstudantesPorNome() {
        estudantes.sort(Comparator.comparing(Estudante::getNome, String.CASE_INSENSITIVE_ORDER));
        idParaIndice.clear();
        for (int i = 0; i < estudantes.size(); i++) {
            idParaIndice.put(estudantes.get(i).getId(), i);
        }
    }

    public List<Estudante> getTodos() { return Collections.unmodifiableList(estudantes); }
}
