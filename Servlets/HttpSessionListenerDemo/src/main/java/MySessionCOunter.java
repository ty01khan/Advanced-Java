import jakarta.servlet.http.*;

public class MySessionCOunter implements HttpSessionListener {
	private static int sessionCount;
	
	public int getActiveSession() {
		return sessionCount;
	}
	
	public void sessionCreated(HttpSessionEvent hse) {
		sessionCount++;
	}
	
	public void sessionDestroyed(HttpSessionEvent hse) {
		sessionCount--;
	}
}
