package Aula3;
import java.util.LinkedList;
import java.util.Scanner;

class TaskManager {
    private LinkedList<String> tasks;

    public TaskManager() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void completeTask() {
        if (!tasks.isEmpty()) {
            tasks.removeFirst(); 
        } else {
            System.out.println("Não há tarefas para concluir.");
        }
    }

    public String getNextTask() {
        if (!tasks.isEmpty()) {
            return tasks.getFirst();
        } else {
            return "Não há tarefas pendentes.";
        }
    }
}

public class TaskManagerConsole {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Sistema de Gerenciamento de Tarefas =====");

        while (true) {
            System.out.println("\nSelecione a operação:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Concluir Tarefa");
            System.out.println("3. Visualizar Próxima Tarefa");
            System.out.println("4. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome da nova tarefa: ");
                    String newTask = scanner.nextLine();
                    manager.addTask(newTask);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    manager.completeTask();
                    System.out.println("Tarefa concluída e removida!");
                    break;
                case 3:
                    System.out.println("Próxima Tarefa: " + manager.getNextTask());
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
