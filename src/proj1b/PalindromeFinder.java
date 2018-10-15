package proj1b;

import edu.princeton.cs.algs4.In;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator offbyone = new OffByOne();
        CharacterComparator offbyN = new OffByN(5);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,offbyN)) {
                System.out.println(word);
            }
        }
    }
}
