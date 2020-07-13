package org.spring.springboot.dao;

import com.ruiyun.im.common.core.RYIMChatListBeanEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO
 * @Author ZhengPeidong
 * @Date 2020/7/13
 **/
@Repository
public interface ChatDao {
    List<RYIMChatListBeanEntity> getChatList(String cid);
}
