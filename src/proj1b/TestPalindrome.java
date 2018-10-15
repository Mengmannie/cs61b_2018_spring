package proj1b;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String s1= "cat";
        assertFalse(palindrome.isPalindrome(s1));
        String s2 = "n";
        assertTrue(palindrome.isPalindrome(s2));
        String s3 = "";
        assertTrue(palindrome.isPalindrome(s3));
        String s4 = "horse";
        assertFalse(palindrome.isPalindrome(s4));
        String s5 = "noon";
        assertTrue(palindrome.isPalindrome(s5));

        String s6 = "flake";
        CharacterComparator offbyone = new OffByOne();
        assertTrue(palindrome.isPalindrome(s6,offbyone));

    }
}
