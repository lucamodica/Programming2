abstract class List{
    public abstract List take(int m, int n);
}

class Nil extends List{
    public List take(int m, int n){
        return this;
    }
    public String toString() {
        return "";
    }
}

class Cons extends List{
    private int elem;
    private List next;
    public Cons(int elem, List next){
        this.elem = elem;
        this.next = next;
    }
    public List take(int m, int n){
        if(m == 0 && n>0){
            return new Cons(elem,next.take(m, n-1));
        }
        else if(n == 1){
            return new Nil();
        }
        return next.take(m-1, n);
    }
    public String toString() {
        return elem + ", " + next.toString();
    }
}

public class es1_1 {

    public static void main(String[] args) {
        
        List l = new Cons(5, new Cons(6, new Cons(7, new Cons(8, new Cons(9, new Cons(10, new Nil()))))));

        System.out.println("Lista l: " + l);
        System.out.println("sottolista (1,4): " + l.take(1, 4));
        
    }
    
}