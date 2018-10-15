package draft;

public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if(rest == null)
            return 1;
        else
            return 1 + rest.size();
    }

    public int get(int i){
        if(i == 0)
            return first;
        else
            return rest.get(i - 1);
    }

    public static IntList incrList(IntList L, int x){
        int n = L.size();
        IntList Q = new IntList(L.get(n - 1) + x, null);
        for(int i = n - 2; i >= 0; i--){
            Q = new IntList(L.get(i) + x, Q);
        }
        return Q;
    }

    public static IntList dincrList(IntList L, int x){
        IntList Q = L;
        for(int i = 0; i < L.size(); i++){
            Q.first = L.get(i) + x;
            Q = Q.rest;
        }
        Q = L;
        return Q;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5,null);
        L = new IntList(10,L);
        L = new IntList(15,L);
//        System.out.println(L.size());
        IntList Q = IntList.incrList(L,1);
        IntList M = IntList.dincrList(L,2);
//        System.out.println(M);
        for(int i = 0; i < L.size(); i++){
            System.out.print("Q "+ Q.get(i)+" M "+M.get(i)+ " L "+L.get(i));
            System.out.println();
        }
    }
}
