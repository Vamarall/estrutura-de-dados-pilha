import java.time.LocalDateTime;

public class Tarefa {

    private String nomeTarefa;
    private TipoTarefa tipoTarefa;
    private String descTarefa;
    private LocalDateTime dataCriacao;
    private Prioridade prioridade;

    private Pilha<Tarefa> pilha = new Pilha<>();

    public Tarefa(String nomeTarefa, TipoTarefa tipoTarefa, String descTarefa, LocalDateTime dataCriacao,
            Prioridade prioridade) {
        this.nomeTarefa = nomeTarefa;
        this.tipoTarefa = tipoTarefa;
        this.descTarefa = descTarefa;
        this.dataCriacao = dataCriacao;
        this.prioridade = prioridade;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public TipoTarefa getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(TipoTarefa tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public String getDescTarefa() {
        return descTarefa;
    }

    public void setDescTarefa(String descTarefa) {
        this.descTarefa = descTarefa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Pilha<Tarefa> getPilha() {
        return pilha;
    }

    public void setPilha(Pilha<Tarefa> pilha) {
        this.pilha = pilha;
    }

    @Override
    public String toString() {
        return "Tarefa [nomeTarefa=" + nomeTarefa + ", tipoTarefa=" + tipoTarefa + ", descTarefa=" + descTarefa
                + ", dataCriacao=" + dataCriacao + ", prioridade=" + prioridade + "]";
    }

    


}
