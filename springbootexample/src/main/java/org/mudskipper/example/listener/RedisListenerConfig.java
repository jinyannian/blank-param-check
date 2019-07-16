package org.mudskipper.example.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisListenerConfig {

	@Autowired
	@Qualifier(RedisListener.SERVICE_NAME)
	private MessageListener messageListener;
	
	@Autowired
	private RedisTemplate  redisTemplate;
	
	@Bean
	RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(redisTemplate.getConnectionFactory());
		container.addMessageListener(listenerAdapter, new PatternTopic("__keyevent@0__:expired"));
		return container;
	}
	
	@Bean
	MessageListenerAdapter adapter() {
		return new MessageListenerAdapter(messageListener);
	}
}
