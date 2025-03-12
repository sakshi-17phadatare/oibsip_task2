import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskManager {
    private Timer timer;
    private SessionManager sessionManager;

    public TimerTaskManager(SessionManager sessionManager, int durationInSeconds) {
        this.sessionManager = sessionManager;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sessionManager.closeSession();
                timer.cancel();
            }
        }, durationInSeconds * 1000);
    }
}

