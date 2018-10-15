package proj1b;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffByN(){
        CharacterComparator offbyN = new OffByN(5);
        char a = 'a';
        char b = 'f';
        assertTrue(offbyN.equalChars(a,b));

        char c = 'a';
        char d = 'q';
        assertFalse(offbyN.equalChars(c,d));
    }
}
