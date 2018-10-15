package proj1b;

public class OffByOne implements CharacterComparator {


//    public boolean isPalindrome(String word){
//        OffByOne offByOne = new OffByOne();
//        for(int i = 0; i < word.length() / 2; i++){
//            if(!offByOne.equalChars(word.charAt(i),word.charAt(word.length() - 1 - i)))
//                return false;
//        }
//        return true;
//    }

    @Override
    public boolean equalChars(char x, char y) {
        int i = x - y;
        if(Math.abs(i)== 1)
            return true;
        else
            return false;
    }
}
