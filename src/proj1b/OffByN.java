package proj1b;

public class OffByN implements CharacterComparator {
    int N;

    OffByN(int N){
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if(diff == N)
            return true;
        else
            return false;
    }
}
