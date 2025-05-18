import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        Scanner sc = new Scanner(System.in);

        // Adicionando algumas tarefas
        gerenciador.adicionarTarefa(new Tarefa("Estudar Java", TipoTarefa.ESTUDO, "Revisar pilhas", LocalDateTime.now(), Prioridade.ALTA));
        gerenciador.adicionarTarefa(new Tarefa("Limpar casa", TipoTarefa.CASA, "Lavar banheiro", LocalDateTime.now(), Prioridade.MEDIA));
        gerenciador.adicionarTarefa(new Tarefa("Pagar contas", TipoTarefa.FINANCEIRA, "Conta de luz", LocalDateTime.now(), Prioridade.ALTA));

        // Listar tarefas
        System.out.println("\n--- Tarefas na pilha ---");
        gerenciador.listarTarefas();

        // Buscar posição de uma tarefa
        System.out.println("\nDigite o nome da tarefa para saber quantas estão à frente:");
        String nomeBusca = sc.nextLine();

        int pos = gerenciador.quantasAFrente(t -> t.getNomeTarefa().equalsIgnoreCase(nomeBusca));
        if (pos == -1) {
            System.out.println("Tarefa não encontrada.");
        } else {
            System.out.println("Há " + pos + " tarefas antes de \"" + nomeBusca + "\".");
        }

        // Desfazer a última tarefa
        System.out.println("\nDesfazendo a última tarefa...");
        gerenciador.desfazerUltimaTarefa();

        // Mostrar tarefas novamente
        System.out.println("\n--- Tarefas após desfazer ---");
        gerenciador.listarTarefas();
    }
}
