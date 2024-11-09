package server.chat;

import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import Models.UserModel;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;


@ServerEndpoint(value = "/chat", configurator = ChatConfigurator.class)
public class ChatUTEShop {
	// Map lưu trữ thông tin user (userID -> UserInfo)
    private static Map<Long, UserModel> userInfoMap = new ConcurrentHashMap<>();
	@OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        
        if (httpSession != null) {
        	System.out.println(httpSession.getAttribute("hello"));
        	UserModel user = (UserModel)httpSession.getAttribute("user");
        	if(user!=null) {
        		 userInfoMap.put(user.getId(),user);
        		 System.out.println("User connected: " + user);
                 // Gửi danh sách user hiện tại cho user mới
                 //sendUserList(session);

                 // Thông báo cho tất cả user khác về user mới
                 //broadcastNewUser(newUser);
        	}
        	else {
                System.out.println("Thông tin user không tìm thấy trong HttpSession.");
                try {
                    session.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        
    }

}
