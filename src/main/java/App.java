import java.util.*;

// Feedback Model
class Feedback {
    private String user;
    private String message;

    public Feedback(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}

// Main Application
public class App {

    private List<Feedback> feedbackList = new ArrayList<>();

    // ✅ Add feedback with validation
    public boolean addFeedback(Feedback feedback) {
        if (feedback == null) return false;

        if (feedback.getUser() == null || feedback.getUser().isEmpty())
            return false;

        if (feedback.getMessage() == null || feedback.getMessage().isEmpty())
            return false;

        feedbackList.add(feedback);
        return true;
    }

    // ✅ Get all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    // ✅ MAIN METHOD (IMPORTANT FOR KUBERNETES)
    public static void main(String[] args) {
        App app = new App();

        System.out.println("🚀 Feedback App Started...");

        // Sample data
        app.addFeedback(new Feedback("User1", "Great app"));
        app.addFeedback(new Feedback("User2", "Needs improvement"));

        // 🔁 Continuous running loop
        while (true) {
            try {
                System.out.println("App running... Total feedback: " + app.getAllFeedback().size());
                Thread.sleep(10000); // 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
