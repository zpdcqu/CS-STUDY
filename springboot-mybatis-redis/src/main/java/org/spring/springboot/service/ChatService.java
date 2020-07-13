package org.spring.springboot.service;

import com.ruiyun.im.common.core.RYIMChatListBeanEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author ZhengPeidong
 * @Date 2020/7/13
 **/
@Service
public interface ChatService {
    List<RYIMChatListBeanEntity> getChatList(String cid);
}
