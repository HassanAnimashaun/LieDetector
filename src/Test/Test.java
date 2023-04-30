package src;

public @interface Test {
    public class LieDetectorTest {

        @Test
        void testEncode() {
            int[] answers = {1, 1, 0, 1, 0, 0, 1};
            int[] expected = {1, 1, 0, 1, 0, 0, 1};
            assertArrayEquals(expected, LieDetector.encode(answers));
        }
    
        @Test
        void testDecodeWeight0() {
            int[] answers = {0, 0, 0, 0, 0, 0, 0};
            String expected = "No lie was told";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight1() {
            int[] answers = {0, 0, 0, 1, 0, 0, 0};
            String expected = "The lie is in the position of the 4 in the string";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight2() {
            int[] answers = {0, 1, 1, 0, 0, 0, 0};
            String expected = "The lie is in the position of the 1 in the string\n[1, 1, 1, 0, 0, 0, 0]";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight3() {
            int[] answers = {0, 1, 1, 1, 0, 0, 0};
            String expected = "The lie is in the position of the 3 in the string\n[0, 1, 0, 1, 0, 0, 0]";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight4() {
            int[] answers = {1, 1, 1, 1, 0, 0, 0};
            String expected = "The lie is in the position of the 2 in the string\n[1, 0, 1, 1, 0, 0, 0]";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight5() {
            int[] answers = {1, 1, 1, 1, 1, 0, 0};
            String expected = "The lie is in the position of the 6 in the string\n[1, 1, 1, 1, 1, 1, 0]";
            assertEquals(expected, LieDetector.decode(answers));
        }
    
        @Test
        void testDecodeWeight6() {
            int[] answers = {1, 1, 1, 1, 1, 1, 0};
            String expected = "The lie is in the position of the 7 in the string\n[1, 1, 1, 1, 1, 1, 1]";
            assertEquals(expected, LieDetector.decode(answers));
        }
    }
}
