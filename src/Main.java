import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ListaEstudantes lista = new ListaEstudantes();
        CadastroDisciplinas cadastro = new CadastroDisciplinas();
        HistoricoNotas historico = new HistoricoNotas();

        lista.adicionarEstudante(new Estudante(1, "Samuel"));
        lista.adicionarEstudante(new Estudante(2, "Danilo"));
        lista.adicionarEstudante(new Estudante(3, "Absalao"));
        lista.adicionarEstudante(new Estudante(4, "Ligia"));
        lista.adicionarEstudante(new Estudante(5, "Goku"));

        cadastro.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastro.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cadastro.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        cadastro.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));

        historico.adicionarMatricula(1, "MAT101", 8.5);
        historico.adicionarMatricula(1, "PRG201", 9.0);
        historico.adicionarMatricula(2, "PRG201", 7.0);
        historico.adicionarMatricula(2, "MAT101", 5.0);
        historico.adicionarMatricula(3, "BD301", 6.5);
        historico.adicionarMatricula(3, "MAT101", 7.5);
        historico.adicionarMatricula(4, "PRG201", 8.0);
        historico.adicionarMatricula(5, "EDF110", 10.0);

        List<String> saida = new ArrayList<>();

        final java.util.function.Consumer<String> println = (s) -> {
            System.out.println(s);
            saida.add(s);
        };

        println.accept("+===========================================+");
        println.accept("| Lista de Estudantes por Ordem de Cadastro");
        println.accept("|");
        for (Estudante e : lista.getTodos()) {
            println.accept(e.toString());
        }
        println.accept("+===========================================+");


        println.accept("| Lista de Estudantes por Ordem Ordenada");
        println.accept("|");
        lista.ordenarEstudantesPorNome();
        String nomesOrdenados = String.join(", ", lista.getTodos().stream().map(Estudante::getNome).toArray(String[]::new));
        println.accept("| " + nomesOrdenados);
        println.accept("+===========================================+");


        println.accept("| Disciplinas por Ordem de Inserção ");
        println.accept("|");
        String codes = String.join(", ", cadastro.obterTodasDisciplinasEmOrdem().stream().map(Disciplina::getCodigo).toArray(String[]::new));
        println.accept("| " + codes);
        println.accept("+===========================================+");


        println.accept("| Matrículas");
        println.accept("|");
        for (Estudante e : lista.getTodos()) {
            List<Matricula> m = historico.obterMatriculas(e.getId());
            String mats = m.isEmpty() ? "(Nenhuma)" : String.join(", ", m.stream().map(Object::toString).toArray(String[]::new));
            println.accept(String.format("| %s: %s [Média: %.2f]", e.getNome(), mats, historico.mediaDoEstudante(e.getId())));
        }
        println.accept("+===========================================+");


        println.accept("| Médias por Disciplina");
        println.accept("|");
        for (Disciplina d : cadastro.obterTodasDisciplinasEmOrdem()) {
            println.accept(String.format("| %s: %.2f", d.getCodigo(), historico.mediaDaDisciplina(d.getCodigo())));
        }
        println.accept("+===========================================+");


        println.accept("| Alunos com média >= 8.0");
        println.accept("|");
        List<String> aprov = new ArrayList<>();
        for (Estudante e : lista.getTodos()) {
            if (historico.mediaDoEstudante(e.getId()) >= 8.0) aprov.add(e.getNome());
        }
        if (aprov.isEmpty()) {
            println.accept("| (Nenhum)");
        } else {
            println.accept("| " + String.join(", ", aprov));
        }
        println.accept("+===========================================+");


        println.accept("| Disciplinas com média < 6.0");
        println.accept("|");
        List<String> baixa = new ArrayList<>();
        for (Disciplina d : cadastro.obterTodasDisciplinasEmOrdem()) {
            if (historico.mediaDaDisciplina(d.getCodigo()) < 6.0) baixa.add(d.getCodigo());
        }
        if (baixa.isEmpty()) {
            println.accept("| (Nenhuma)");
        } else {
            println.accept("| " + String.join(", ", baixa));
        }
        println.accept("+===========================================+");


        Path caminho = Paths.get("output.txt");
        try {
            Files.write(caminho, saida, StandardCharsets.UTF_8);
            System.out.println("\nArquivo 'output.txt' gerado com sucesso");
        } catch (IOException ex) {
            System.err.println("Erro ao gravar output.txt");
        }
    }
}
