package com.keep.web;

import com.keep.domain.Note;
import com.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("login")
    public String login(String json){
        return "index";
    }

    @RequestMapping("index")
    public String test(){

        return "{\"index\":\"1\"}";
    }

    @RequestMapping("note")
    public Note note(){
        Note note = new Note();
        note.setTitle("note 1");
        note.setContent("note content 1");

        return note;
    }


}
