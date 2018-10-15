package lab3.Flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testisSameNumber(){
        Integer a = 128;
        Integer b = 128;
        int c = 128;
        int d = 128;
        assertTrue(Flik.isSameNumber(a,b));
        assertTrue(Flik.isSameNumber(c,d));
    }
}
