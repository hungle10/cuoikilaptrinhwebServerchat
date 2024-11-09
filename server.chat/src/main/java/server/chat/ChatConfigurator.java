package server.chat;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class ChatConfigurator extends ServerEndpointConfig.Configurator {
	 @Override
	    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
	        // Lấy HttpSession từ HandshakeRequest
	        HttpSession httpSession = (HttpSession) request.getHttpSession();
	        
	        // Thêm HttpSession vào UserProperties
	        if (httpSession != null) {
	            config.getUserProperties().put("httpSession", httpSession);
	        }
	    }

}
