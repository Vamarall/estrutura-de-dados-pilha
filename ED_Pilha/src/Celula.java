public class Celula<E>{

    private E item;
    private Celula<E> proximaCelula;

    public Celula(){
        this.item = null;
        setProximaCelula(null);

    }

    public Celula(E item, Celula<E> proximaCelula){
        this.item = item;
        this.proximaCelula = proximaCelula;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Celula<E> getProximaCelula() {
        return proximaCelula;
    }

    public void setProximaCelula(Celula<E> proximaCelula) {
        this.proximaCelula = proximaCelula;
    }
    
}
