package server.chat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.websocket.Session;

public class WebSocketManager {
	 private static Map<String, Session> userSessions = new ConcurrentHashMap<>();

	    public static void addSession(String userId, Session session) {
	        userSessions.put(userId, session);
	    }

	    public static void removeSession(String userId) {
	        userSessions.remove(userId);
	    }

	    public static Session getSession(String userId) {
	        return userSessions.get(userId);
	    }

}
