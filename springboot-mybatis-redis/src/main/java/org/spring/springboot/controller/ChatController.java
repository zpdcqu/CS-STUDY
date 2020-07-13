package org.spring.springboot.controller;

import com.ruiyun.im.common.core.RYIMChatListBeanEntity;
import org.spring.springboot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: TODO
 * @Author ZhengPeidong
 * @Date 2020/7/13
 **/
@Controller
public class ChatController {

    @Autowired
    ChatService chatService;
    @RequestMapping(value = "/api/chat/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public List<RYIMChatListBeanEntity> getChatList(@PathVariable String cid){
        return chatService.getChatList(cid);
    }
}
