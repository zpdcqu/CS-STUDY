package org.spring.springboot.service.impl;

import ch.qos.logback.classic.Logger;
import com.ruiyun.im.common.core.RYIMChatListBeanEntity;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.ChatDao;
import org.spring.springboot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author ZhengPeidong
 * @Date 2020/7/13
 **/
@Service
public class ChatServiceImpl implements ChatService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ChatServiceImpl.class);;
    @Autowired
    ChatDao chatDao;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<RYIMChatListBeanEntity> getChatList(String cid) {
        // 从缓存中获取城市信息
        String key = "chat_" + cid;
        ValueOperations<String, List<RYIMChatListBeanEntity>> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<RYIMChatListBeanEntity> chatList = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中聊天列表 >> ");
            return chatList;
        }

        // 从 DB 中获取城市信息
        List<RYIMChatListBeanEntity> chatList = chatDao.getChatList(cid);


        // 插入缓存
        operations.set(key, chatList, 10, TimeUnit.SECONDS);
        LOGGER.info("插入缓存 >> " );

        return chatList;

    }
}
