package org.spring.springboot.service.impl;

import ch.qos.logback.classic.Logger;
import com.ruiyun.im.common.core.RYIMChatListBeanEntity;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.ChatDao;

import org.spring.springboot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    @Cacheable(value = {"chatList"}, key = "#cid",sync = true)
    public List<RYIMChatListBeanEntity> getChatList(String cid) {

        // 从 DB 中获取城市信息
        List<RYIMChatListBeanEntity> chatList = chatDao.getChatList(cid);
        LOGGER.info("插入缓存 >> " );
        return chatList;
    }

    @CachePut(value = "chatList")
    public void updateCityDescription(String cid){
        List<RYIMChatListBeanEntity> chatList = chatDao.getChatList(cid);

    }
}
