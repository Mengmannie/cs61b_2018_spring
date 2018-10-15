package proj1b;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
   @Test
   public void testequalChars(){
       char a = 'A';
       char b = 'B';
       assertTrue(offByOne.equalChars(a,b));

       char c = 'g';
       char d = 'h';
       assertTrue(offByOne.equalChars(c,d));

       char e = 'k';
       char f = 'j';
       assertTrue(offByOne.equalChars(e,f));
   }


}
