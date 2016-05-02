package com.keep.web;

import com.google.gson.Gson;
import com.keep.domain.Note;
import com.keep.domain.Tag;
import com.keep.domain.User;
import com.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @RequestMapping("note")
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

}
