package com.isa.donorapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.isa.donorapp.jwt.JwtUtils;
import com.isa.donorapp.model.Role;
import com.isa.donorapp.model.User;
import com.isa.donorapp.model.enums.ERole;
import com.isa.donorapp.service.UserDetailsServiceImpl;
import com.isa.donorapp.service.UserService;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private UserService userService;
	
	
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
        		.setAllowedOrigins("http://localhost:4200")
                //.setAllowedOrigins("*")
                //.setAllowedOriginPatterns("")
                //.setAllowedOrigins("**")
                .withSockJS();
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
            	
            	//Svuda je bilo return message
            	
            	System.out.println("11111111111111111111111111");
                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
                System.out.println(accessor);
                
                if (accessor.getMessageType() != SimpMessageType.DISCONNECT) {
	                List<String> tokenList = accessor.getNativeHeader("X-Authorization");
	                String token = null;
	                System.out.println("2");
	                if (tokenList == null)
	                	System.out.println("2.1");
	                if (tokenList == null || tokenList.isEmpty()) {
	                	System.out.println("3");
	                    return null;
	                } else {
	                	System.out.println("4");
	                    token = tokenList.get(0);
	                    if (token == null) {
	                        return null;
	                    }
	                }
	                System.out.println("5");
	                
	                String jwt = token.substring(7, token.length());
	    			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
	    				String email = jwtUtils.getEmailFromJwtToken(jwt);
	    				UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	    				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	    						userDetails, null, userDetails.getAuthorities());
	    				//authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    				
	    				//SecurityContextHolder.getContext().setAuthentication(authentication);
	    				
	    				System.out.println(authentication.getName());
	    				User user = userService.findByEmail(authentication.getName());
	    				if (user == null)
	    					return null;
	    				Role role = null;
	    				System.out.println("5.5");
	    				for (Role r : user.getRoles()) {
							role = r;
						}
	    				System.out.println(role);
	    				System.out.println(role.getName());
	    				if (role == null || (role.getName() != ERole.STAFF && role.getName() != ERole.ADMINISTRATOR))
	    					return null;
	    				
	    				
	    				accessor.setUser(authentication);
	    				// Set leaveMutable to true, otherwise, you may get an NPE in StompSubProtocolHandler
	    				accessor.setLeaveMutable(true);
	    			}
                }
                System.out.println("6");
	            return MessageBuilder.createMessage(message.getPayload(), accessor.getMessageHeaders());
            }
        });
    }
}
