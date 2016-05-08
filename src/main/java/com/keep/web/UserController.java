package com.keep.web;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.keep.domain.MessageBean;
import com.keep.domain.Note;
import com.keep.domain.Tag;
import com.keep.domain.User;
import com.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by tcf24 on 2016/4/11.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{user}/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@PathVariable("user") String user,@RequestParam("token") String token){

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH,Calendar.MONTH+1);

        User tmp = new User();
        tmp.setUsername(user);
        tmp.setToken(token);
        User u =  userService.findUser(tmp);

        if(null != u){

           if(System.currentTimeMillis() >= u.getExpireTime().getTime()){
               u.setExpireTime(c.getTime());
               userService.update(u);
           }

        }else{
            tmp.setExpireTime(c.getTime());
            userService.save(tmp);
        }
        MessageBean me = new MessageBean();
        me.setFlag(true);
        me.setData(UUID.randomUUID());
        return JSON.toJSONString(me);
    }

    @RequestMapping(value = "note",method = RequestMethod.GET)
    public Note note(){
        Note note = new Note();
        User user = new User();
        Tag tag = new Tag();
        note.setTitle("note 1");
        note.setContent("note content 1");
        note.setOwner(user);

        return note;
    }


    @RequestMapping("test")
    public String testString(){
        Note note = new Note();
        User user = new User();
        Tag tag = new Tag();
        note.setTitle("note 1");
        note.setContent("note content 1");
        note.setOwner(user);

        Gson gson = new Gson();
        String json = gson.toJson(note);
        return json;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String reg(HttpServletRequest req , @RequestParam("username") String username, @RequestParam("password") String password){
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        userService.register(u);
        MessageBean mb = new MessageBean();
        mb.setFlag(true);
        return JSON.toJSONString(mb);

    }

    @RequestMapping("/upPwd")
    public  String updatePwd(){
        return JSON.toJSONString(new MessageBean(true));
    }
}
