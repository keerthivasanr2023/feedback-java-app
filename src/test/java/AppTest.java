
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // ✅ Valid feedback test
    @Test
    void testValidFeedback() {
        App app = new App();
        Feedback f = new Feedback("User1", "Nice app");
        assertTrue(app.addFeedback(f));
    }

    // ❌ Empty user
    @Test
    void testEmptyUser() {
        App app = new App();
        Feedback f = new Feedback("", "Nice app");
        assertFalse(app.addFeedback(f));
    }

    // ❌ Empty message
    @Test
    void testEmptyMessage() {
        App app = new App();
        Feedback f = new Feedback("User1", "");
        assertFalse(app.addFeedback(f));
    }

    // ❌ Null feedback
    @Test
    void testNullFeedback() {
        App app = new App();
        assertFalse(app.addFeedback(null));
    }

    // ✅ Retrieve feedback
    @Test
    void testRetrieveFeedback() {
        App app = new App();
        app.addFeedback(new Feedback("User1", "Good"));

        assertEquals(1, app.getAllFeedback().size());
        assertEquals("User1", app.getAllFeedback().get(0).getUser());
    }
}