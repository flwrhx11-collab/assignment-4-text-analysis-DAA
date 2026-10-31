package textanalysis.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditDistanceTest {
    @Test
    public void testEditDistance() {
        EditDistance ed = new EditDistance();
        assertEquals(0, ed.calculate("abc", "abc"));
        assertEquals(3, ed.calculate("", "abc"));
        assertEquals(3, ed.calculate("kitten", "sitting"));
    }
}