package com.areca.my_spring_boot.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		session.sendMessage(new TextMessage("服务器的时间: " + System.currentTimeMillis()));
	}

	
}
