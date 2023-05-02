import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LieDetectorTest {
    
    @Test
    public void testEncode() {
        int[] answers = new int[7];
        answers[0] = 1;
        answers[1] = 0;
        answers[2] = 1;
        answers[3] = 0;
        answers[4] = 1;
        answers[5] = 0;
        answers[6] = 1;
        int[] expected = {1, 0, 1, 0, 1, 0, 1};
        assertArrayEquals(expected, LieDetector.encode(answers));
    }
    
    @Test
    public void decode1() {
    	System.out.print("\n");
    	int[] answers = {0, 0, 0, 0, 0, 0, 0};
        int expected = 0;
        assertEquals(expected, LieDetector.decode(answers));
    }
    @Test
    public void decode2() {
    	System.out.print("\n");
    	int[] answers = {1, 0, 0, 0, 0, 0, 0};
        int expected = 1 ;
        assertEquals(expected, LieDetector.decode(answers));
    }
    
    @Test
    public void decode3() {
    	System.out.print("\n");
    	int[] answers = {0, 1, 0 , 0, 1, 0, 0};
        int expected = 2 ;
        assertEquals(expected, LieDetector.decode(answers));
    }
    @Test
    public void decode4() {
    	System.out.print("\n");
    	int[] answers = {0 , 1, 0, 1, 1, 0, 0};
        int expected = 3;
        assertEquals(expected, LieDetector.decode(answers));
    }
    @Test
    public void decode5() {
    	System.out.print("\n");
    	int[] answers = {1 , 1, 0, 1, 1, 1, 0};
        int expected = 4 ;
        assertTrue(LieDetector.decode(answers) >= expected);
    }
    @Test 
    public void decode6() {
    	System.out.print("\n");
    	int[] answers = {0 , 1, 1, 1, 1, 1, 1};
        int expected = 4;
        assertTrue(LieDetector.decode(answers) >= expected);
    }
   

}