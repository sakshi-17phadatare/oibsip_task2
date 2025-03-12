public class SessionManager {
    private boolean isSessionActive;

    public SessionManager() {
        this.isSessionActive = true;
    }

    public boolean isSessionActive() {
        return isSessionActive;
    }

    public void closeSession() {
        isSessionActive = false;
        System.out.println("Session has been closed. Auto-submitting your answers...");
    }
}

