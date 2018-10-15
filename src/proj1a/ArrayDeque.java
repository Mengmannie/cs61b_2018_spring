package proj1a;

public class ArrayDeque<T> {
    T[] item ;
    int size ;
    int nextFirst ;
    int nextLast;
    T[] array ;
    private final int RFACTOR = 10;

    public ArrayDeque(){
        item = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(T x){
        item = (T[]) new Object[8];
        size = 1;
        nextFirst = 4;
        nextLast = 5;
        item[nextFirst] = x;
        nextFirst--;

    }

    public void initial(){
        if(nextLast == item.length )
            nextLast = 0;
        if(nextFirst == -1)
            nextFirst = item.length - 1;
    }

    public void resize(int size){
        T[] a = (T[]) new Object[size];
        System.out.println("item.length "+ item.length);
        System.arraycopy(item,0,a,0,item.length);
        item = a;
    }

    public void addFirst(T x){
        if(item.length == size) {
            size = size * RFACTOR;
            resize(size);
        }
        initial();
        item[nextFirst] = x;
        nextFirst--;
        size++;
    }

    public void addLast(T x){
//        System.out.println("nextLast "+ nextLast+" size "+size);
        if(item.length == size) {
            size = size * RFACTOR;
            resize(size);
        }
        initial();
        item[nextLast] = x;
        nextLast++;
        size++;
    }

    public boolean isEmpty(){
        if (size ==0)
            return true;
        else
            return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){

        array = (T[]) new Object[size];
        int f = 0;

        if(nextLast < 5 || nextFirst > 4 ){
            for(int i = nextFirst + 1 ; i < item.length; i++) {
                array[f] = item[i];
                f++;
            }

            for(int i = 0; i < nextLast; i++) {
                array[f] = item[i];
                f++;
            }
        }
        else {
            for(int i = nextFirst + 1 ; i < nextLast; i++){
                array[f] = item[i];
                f++;
            }
        }

        for(int i = 0; i < array.length; i++) {
            if(array[i] != null)
            System.out.print(array[i] + " ");
        }

    }

    public T removeFirst(){
        T remove = item[nextFirst + 1];
        size--;
        nextFirst++;
        return remove;
    }

    public T removeLast(){
        T remove = item[nextLast - 1];
        size--;
        nextLast--;
        return remove;
    }

    public T get(int x){
        return array[x - 1];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> aL = new ArrayDeque<>(100);
        aL.addFirst(1);
        aL.addLast(2);
        aL.addLast(6);
        aL.addFirst(0);
        aL.addFirst(-1);
        aL.addFirst(-2);
        aL.addFirst(10);
        aL.addLast(200);
        System.out.println("nextFirst "+ aL.nextFirst+" nextLast "+ aL.nextLast);

        aL.printDeque();
        System.out.println();
//        System.out.println(aL.size);
        System.out.println(aL.get(8));
        System.out.println(aL.removeFirst());
        System.out.println(aL.removeLast());
    }



}
