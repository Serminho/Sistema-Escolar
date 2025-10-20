# 🏫 Sistema Escolar – Projeto Java

**Integrante:**  
Samuel Egson Milhomem Rodrigues

---

## 📘 Descrição do Projeto

O **Sistema Escolar** é um programa desenvolvido em **Java** que gerencia estudantes, disciplinas e matrículas, calculando médias individuais e por disciplina.  
Ele organiza os dados de forma eficiente, gera uma listagem completa das informações no console e cria automaticamente um arquivo `output.txt` com o mesmo conteúdo formatado.

---

## 🧩 Estrutura e Justificativa das Coleções

O projeto utiliza as coleções **List**, **Set** e **Map** de acordo com a necessidade de cada classe.  
Na classe `ListaEstudantes`, foi usada a implementação **ArrayList**, pois permite armazenar estudantes na ordem em que foram cadastrados, além de facilitar o acesso rápido por índice. Isso torna simples a exibição e a ordenação dos alunos.  

Na classe `CadastroDisciplinas`, também foi usada uma **List**, mantendo as disciplinas na ordem de inserção e permitindo consultas rápidas. A escolha de uma lista facilita a manipulação e exibição das disciplinas sem necessidade de controle adicional de duplicidade.  

Já na classe `HistoricoNotas`, foi utilizado um **Map**, mais especificamente um **HashMap**, que associa cada estudante (por meio do seu ID) à sua lista de matrículas. Essa estrutura foi escolhida porque oferece acesso e inserção muito rápidos, praticamente **O(1)**, e permite gerenciar eficientemente as notas e médias de cada aluno.  

Essas escolhas priorizaram **simplicidade, clareza e eficiência**, sendo ideais para o estágio introdutório de uso de coleções em Java.

---

## ▶️ Como Executar o Programa e Gerar o `output.txt`

1. **Certifique-se de que todos os arquivos `.java`** (classes do sistema) estão no mesmo diretório.  
   - Exemplo: `Main.java`, `Estudante.java`, `Disciplina.java`, `Matricula.java`, `ListaEstudantes.java`, `CadastroDisciplinas.java`, `HistoricoNotas.java`

2. **Compile o projeto:**
   ```bash
   javac *.java
   ```

3. **Execute o programa:**
   ```bash
   java Main
   ```

4. **O programa exibirá todos os dados no console e, ao final, criará o arquivo:**

- output.txt
Esse arquivo será salvo no mesmo diretório de execução e conterá toda a saída formatada.

## ⚙️ Desafios Encontrados

Durante o desenvolvimento, o principal desafio foi estruturar as classes e coleções de forma simples, mas eficiente, especialmente ao vincular estudantes e disciplinas por meio das matrículas.
Outro ponto foi gerar o arquivo output.txt sem perder a formatação visual do console.
O uso de List e Map facilitou a implementação e reduziu a complexidade, mantendo o código próximo de O(1) nas operações principais de busca e inserção.

## 📄 Resultado Final

Ao executar o programa, o usuário obtém:

- Listas ordenadas de estudantes e disciplinas;

- Médias por aluno e por disciplina;

- Relação de alunos aprovados e disciplinas com baixa média;

- E o arquivo output.txt com toda a saída salva automaticamente.

---

## 🤖 Observação

Parte da formatação e revisão textual deste README foi melhorada com a ajuda de **IA**, com o objetivo de deixá-lo **mais bonito, claro e profissional**, sem alterar o conteúdo técnico do trabalho.
