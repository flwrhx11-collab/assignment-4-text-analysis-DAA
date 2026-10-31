package textanalysis.matching;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringMatchingTest {
    @Test
    public void testAlgorithmsMatch() {
        NaiveSearch naive = new NaiveSearch();
        KMP kmp = new KMP();
        RabinKarp rk = new RabinKarp();

        String text = "ababcababcabc";
        String pattern = "abc";

        List<Integer> expected = naive.search(text, pattern);
        assertEquals(expected, kmp.search(text, pattern));
        assertEquals(expected, rk.search(text, pattern));
    }
}