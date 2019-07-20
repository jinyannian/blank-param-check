package com.example.demo.listener;

import com.example.demo.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service(value = RedisListener.SERVICE_NAME)
public class RedisListener implements MessageListener {

	public Logger log = LoggerFactory.getLogger(RedisListener.class);
	
	public static final String SERVICE_NAME = "com.founder.ihc.standard.listener.RedisListener";
	
	@Autowired
    RedisService redisService;
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("===============RedisListener开始处理过期key=============");
		String expiredKey = new String(message.getBody());
		log.info("要处理的key为[{}]value为[{}]",expiredKey,(String)redisService.get("expiredKey"));
		//业务处理
		
		log.info("===============RedisListener结束处理过期key=============");
	}

}
