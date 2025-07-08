import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private final String arquivo = "tarefa.txt";
    private int proximoId = 1;

    public GerenciadorTarefas() {
        carregarArquivo();
    }

    private void carregarArquivo() {
        //FileReader fr = null;
        //BufferedReader br = null;
        //try {
        //    fr = new FileReader(arquivo);
        //    br = new BufferedReader(fr);
        //} catch (FileNotFoundException e) {
        //    System.out.println("Arquivo não encontrado" + e.getMessage());
        //}

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String linha;
            while((linha = br.readLine()) != null){
                Tarefa t = Tarefa.separaLinha(linha);
                tarefas.add(t);
                //pego o que for maior e salva como promixo id.
                proximoId = Math.max(proximoId, t.getId()+1);
            };
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao Ler o arquivo - " + e.getMessage());
        }
    }
     private void gravarArquivo(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
            for(Tarefa t : tarefas){
                bw.write(t.converteParaLinha(t.getId(), t.getTitulo(), t.getDescricao()));
                bw.newLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado - "+ e.getMessage());
        } catch (IOException e){
            System.out.println("Erro ao gravar o arquivo - "+ e.getMessage());
        }
     }

    // listar tarefas
    // vai listar só na tela, nao retorna lista
    public void listar(){
        if(tarefas.isEmpty()){
            System.out.println("Sem tarefa cadastrada.");
            return;
        }
        for(Tarefa t : tarefas){
            System.out.println("-----------------------");
            System.out.println("ID: " + t.getId());
            System.out.println("Título: " + t.getTitulo());
            System.out.println("Descrição: " + t.getDescricao());
            System.out.println("-----------------------");
        }
    }
    // adicionar tarefa
    public void adicionarTarefa(String titulo, String descricao){
        // iteracao direto no valor do int.
        Tarefa t = new Tarefa(proximoId++,titulo,descricao);
        tarefas.add(t);
        gravarArquivo();
    }
    // deletar tarefa
    public void deletarTarefa(int id){
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
        gravarArquivo();
    }


}
