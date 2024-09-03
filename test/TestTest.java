import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 2.3
 */
public class TestTest {

    /**
     * Testet ob Tests testbar testen
     */
    @Test
    void test1() {
        assertEquals("a","a", "Tests nicht testbar");
    }
}
