package proj1b;

public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> wordLL = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            wordLL.addLast(word.charAt(i));
        }
        return wordLL;
    }

    public boolean isPalindrome(String word){
        Palindrome palindrome = new Palindrome();
        Deque<Character> deque = palindrome.wordToDeque(word);

        if(palindrome.isPalindrome(deque))
            return true;
        else
            return false;

    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        for(int i = 0; i < word.length() / 2; i++){
            if(!cc.equalChars(word.charAt(i),word.charAt(word.length() - 1 - i)))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(Deque<Character> word){
        if(word.size() == 0 || word.size() == 1)
            return true;

            Character f = word.removeFirst();
            Character l = word.removeLast();

            if(f == l && isPalindrome(word))
                return true;
            else
                return false;
    }
}
