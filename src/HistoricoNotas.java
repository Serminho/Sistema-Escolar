import java.util.*;

public class HistoricoNotas {
    private final Map<Integer, List<Matricula>> mapa = new HashMap<>();
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        mapa.computeIfAbsent(idEstudante, k -> new ArrayList<>()).add(new Matricula(codigoDisciplina, nota));
    }
    public List<Matricula> obterMatriculas(int idEstudante) {
        return mapa.getOrDefault(idEstudante, Collections.emptyList());
    }
    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        List<Matricula> lst = mapa.get(idEstudante);
        if (lst == null) return Optional.empty();
        for (Matricula m : lst)
        if (m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina)) return Optional.of(m.getNota());
        return Optional.empty();
    }

    public boolean removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> lst = mapa.get(idEstudante);
        if (lst == null) return false;
        boolean removed = lst.removeIf(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina));
        if (lst.isEmpty()) mapa.remove(idEstudante);
        return removed;
    }

    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> lst = mapa.get(idEstudante);
        if (lst == null || lst.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Matricula m : lst) soma += m.getNota();
        return soma / lst.size();
    }

    public double mediaDaDisciplina(String codigoDisciplina) {
        double soma = 0.0;
        int conta = 0;
        for (List<Matricula> lst : mapa.values()) {
            for (Matricula m : lst) {
                if (m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina)) {
                    soma += m.getNota(); conta++;
                }
            }
        }
        return conta == 0 ? 0.0 : soma / conta;
    }

    public List<Integer> obterIdsMatriculados() {
        return new ArrayList<>(mapa.keySet());
    }
}
