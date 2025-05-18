import java.util.function.Predicate;

public class Pilha<E> {

    private Celula<E> fundo;
    private Celula<E> topo;

    public Pilha() {
        Celula<E> sentinela = new Celula<>();
        this.fundo = sentinela;
        this.topo = sentinela;
    }

    public boolean isEmpty() {
        return (fundo == topo);
    }

    public void push(E item) {
        Celula<E> novaCelula = new Celula<E>(item, topo);
        this.topo = novaCelula;

    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = consultarTopo();
        topo = topo.getProximaCelula();
        return item;

    }

    public E consultarTopo() {
        if (isEmpty()) {
            return null;
        }

        E item = topo.getItem();
        return item;
    }

    public void concatenar(Pilha<E> pilha) {
        if (this == pilha) {
            System.out.println("Nao é possivel concatenar a pilha com ela mesma");
            return;
        }
        Pilha<E> auxPilha = new Pilha<>();
        Celula<E> aux = pilha.topo;

        // Copia os elementos da outra pilha para a auxiliar (revertendo a ordem)
        while (aux != pilha.fundo) {
            auxPilha.push(aux.getItem());
            aux = aux.getProximaCelula();
        }

        // Agora insere na pilha atual, preservando a ordem da original
        while (!auxPilha.isEmpty()) {
            this.push(auxPilha.pop());
        }
    }

    public E item(Predicate<E> condicional){
        if (isEmpty()) {
            return null;
        }
        Celula<E> aux = this.topo;
        while(aux != null){
            if(condicional.test(aux.getItem())){
                return aux.getItem();
            }
            aux = aux.getProximaCelula();
        }
        return null;
    }

    public int quantosAFrente(E item){
        if (isEmpty()) {
            return 0;
        }

        Celula<E> aux = this.topo;
        int cont = 0;

        while(aux != fundo){
            if(aux.getItem().equals(item)){
                return cont;
            }
            aux = aux.getProximaCelula();
            cont ++;
        }

        return -1;

    }

    public int obterNumeroItens() {
        if (isEmpty()) {
            return 0;
        }
        Celula<E> aux = this.topo;
        int cont = 0;

        while (aux != fundo) { // Para no fundo (sentinela)
            cont++;
            aux = aux.getProximaCelula();

        }
        return cont;
    }

    public void inverter() {
        if (isEmpty()) {
            return;
        }

        Pilha<E> pilhaAux = new Pilha<>();

        while (!this.isEmpty()) {
            pilhaAux.push(this.pop());
        }

        while (!pilhaAux.isEmpty()) {
            this.push(pilhaAux.pop());
        }
    }

    public boolean verificaExistencia(E item) {
        if (isEmpty()) {
            return false;
        }
        Celula<E> aux = this.topo;

        while (aux != null) {
            if (aux.getItem().equals(item)) {
                return true;
            }
            aux = aux.getProximaCelula();
        }

        return false;
    }

    public void removerItem(E item) {
        if (isEmpty()) {
            return;
        }

        Pilha<E> auxPilha = new Pilha<>();

        while (!this.isEmpty()) {
            E atual = this.pop();
            if (!atual.equals(item)) {
                auxPilha.push(atual); // Guarda somente os diferentes
            }

        }

        // Recoloca os itens de volta na pilha original, restaurando a ordem
        while (!auxPilha.isEmpty()) {
            this.push(auxPilha.pop());
        }

    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("⚠️ Pilha vazia.");
            return;
        }

        Pilha<E> auxPilha = new Pilha<>();

        while (!this.isEmpty()) {
            E item = this.pop();
            auxPilha.push(item);
            System.out.println(item);
        }

        while (!auxPilha.isEmpty()) {
            this.push(auxPilha.pop());
        }
    }

}
