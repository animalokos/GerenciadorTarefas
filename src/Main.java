import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        int opcao = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar Buffer

            switch (opcao){
                case 1:
                    System.out.print("qual o titulo? ");
                    String titulo = sc.nextLine();
                    System.out.print("qual a descrição? ");
                    String descricao = sc.nextLine();
                    gerenciador.adicionarTarefa (titulo, descricao);
                    break;
                case 2:
                    System.out.println("Listando as tarefas");
                    gerenciador.listar();
                    break;
                case 3:
                    System.out.println("Qual o id da tarefa que deseja remover?");
                    int id = sc.nextInt();
                    gerenciador.deletarTarefa(id);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}