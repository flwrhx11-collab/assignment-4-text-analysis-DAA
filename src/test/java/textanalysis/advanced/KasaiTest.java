package textanalysis.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KasaiTest {
    @Test
    public void testKasai() {
        Kasai kasai = new Kasai();
        String text = "banana";
        int[] suffixArray = {5, 3, 1, 0, 4, 2};
        int[] expectedLCP = {1, 3, 0, 0, 2, 0};

        int[] result = kasai.buildLCP(text, suffixArray);
        assertArrayEquals(expectedLCP, result);
    }
}