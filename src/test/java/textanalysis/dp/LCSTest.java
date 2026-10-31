package textanalysis.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCSTest {
    @Test
    public void testLCS() {
        LCS lcs = new LCS();
        assertEquals(3, lcs.findLCS("abc", "abc"));
        assertEquals(0, lcs.findLCS("abc", "def"));
        assertEquals(0, lcs.findLCS("", "abc"));
    }
}