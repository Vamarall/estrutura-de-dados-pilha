public class Pilha<E> {

    private Celula<E> fundo;
    private Celula<E> topo;

    public Pilha() {
        Celula<E> sentinela = new Celula<>();
        sentinela = topo = fundo;
    }

    public boolean isEmpty() {
        return (fundo == topo);
    }

    public void push(E item) {
        Celula<E> novaCelula = new Celula<E>(item, topo);
    }


    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = consultarTopo();
        topo = topo.getProximaCelula();
        return item;


    }

    public E consultarTopo(){
        if(isEmpty()){
            return null;
        }

        E item = topo.getItem();
        return item;
    }

}
