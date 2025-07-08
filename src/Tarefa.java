public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;

    public Tarefa(int id, String titulo, String descricao){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    //transforma o toString para ler direto (id + titulo + descricao)
    public static String converteParaLinha(int id,String titulo, String descricao){
        return id+";"+titulo+";"+descricao;
    }

    // carregar a tafefa separando por ponto e virgula.
    // usando static para nao precisar instanciar um objeto antes de usar.
    public static Tarefa separaLinha(String tarefaLinha){
        String[] partes = tarefaLinha.split(";");
        Tarefa t = new Tarefa(Integer.parseInt(partes[0]), partes[1], partes[2]);
        return t;
    }

}
