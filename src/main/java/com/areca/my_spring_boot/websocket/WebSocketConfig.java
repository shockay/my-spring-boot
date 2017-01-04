package com.areca.my_spring_boot.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(myHandler(), "/myHandler").withSockJS(); //这里demo里加上withSockJS()，结果不通
		registry.addHandler(myHandler(), "/myHandler");
	}

	@Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
	
}
