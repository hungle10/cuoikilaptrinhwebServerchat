package server.chat;


import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.websocket.*;
@ServerEndpoint("/chat1")
public class ChatWebSocket {
	// Map lưu trữ session của người dùng (userID -> session)
	private static Map<String, Session> userSessions = new ConcurrentHashMap<>();

	@OnOpen
	public void onOpen(Session session) {
        System.out.println("Connect success");
		}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		if (message.startsWith("register|")) {
            String userId = message.split("\\|")[1];
            session.getUserProperties().put("userID", userId);
            userSessions.put(userId, session);
            System.out.println("User registered with ID: " + userId);
            WebSocketManager.addSession(userId,session);
            // Cập nhật và gửi danh sách user tới tất cả các client
            broadcastUserList();
            return;
        }
		// Giả sử message có format: "userID_from|userID_to|message"
		String[] messageParts = message.split("\\|");
		 String senderId = (String) session.getUserProperties().get("userID");
		String receiverId = messageParts[1];
		String chatMessage = messageParts[2];

		// Tìm session của người nhận
	    Session recipientSession = WebSocketManager.getSession(receiverId);
	    
	    if (recipientSession != null) {
	        // Gửi tin nhắn tới người nhận
	        recipientSession.getAsyncRemote().sendText(senderId  + "|" + chatMessage +"id session cua ng gui" + session.getId());
	    } else {
	        // Người nhận không trực tuyến
	        System.out.println("Người nhận không trực tuyến.");
	    }
	}

	@OnClose
	public void onClose(Session session) {
		String userId = (String) session.getUserProperties().get("userID");
        if (userId != null) {
            userSessions.remove(userId);
            System.out.println("User disconnected with ID: " + userId);

            // Cập nhật và gửi danh sách user sau khi user ngắt kết nối
            broadcastUserList();
        }
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
	    System.out.println("Error on session " + session.getId() + ": " + throwable.getMessage());
	    throwable.printStackTrace(); // Ghi lại stack trace của lỗi
	}
	// Hàm để gửi danh sách user tới tất cả các client
    private void broadcastUserList() {
        String userList = "userList|" + String.join(",", userSessions.keySet());
        for (Session session : userSessions.values()) {
            session.getAsyncRemote().sendText(userList);
        }
    }
}
