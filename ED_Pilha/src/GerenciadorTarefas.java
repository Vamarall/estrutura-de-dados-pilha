import java.time.LocalDateTime;
import java.util.function.Predicate;

public class GerenciadorTarefas {
    private Pilha<Tarefa> pilha = new Pilha<>();

    public void adicionarTarefa(Tarefa tarefa) {
        pilha.push(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void desfazerUltimaTarefa() {
        if (pilha.isEmpty()) {
            System.out.println("Nenhuma tarefa para desfazer!");
            return;
        }
        Tarefa tarefa = pilha.pop();
        System.out.println("Tarefa desfeita: " + tarefa);
    }

    public int quantasAFrente(Predicate<Tarefa> condicao) {
        Tarefa t = pilha.item(condicao);
        if (t == null) return -1;
        return pilha.quantosAFrente(t);
    }

    public void listarTarefas() {
        pilha.imprimir();
    }
}
