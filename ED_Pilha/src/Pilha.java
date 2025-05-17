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
        while(!auxPilha.isEmpty()){
            this.push(auxPilha.pop());
        }
    }

    public int obterNumeroItens(){
        if(isEmpty()){return 0;}
        Celula<E> aux = this.topo;
        int cont = 0;

        while(aux != fundo){ //Para no fundo (sentinela)
            cont ++;
            aux = aux.getProximaCelula();

        }
        return cont;
    }

    public void inverter(){
        if(isEmpty()){ return ;}

        Pilha<E> pilhaAux = new Pilha<>();
        

        while(!this.isEmpty()){
           pilhaAux.push(this.pop());
        }

        while(!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }
    }

}
