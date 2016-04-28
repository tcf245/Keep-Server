package com.keep.web;

import com.keep.domain.Note;
import com.keep.domain.User;
import com.keep.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by BFD_303 on 2016/4/28.
 */
@RestController
public class NotesController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("all")
    public String getAll(User user){
        List<Note> notes = noteService.getAll(user);
//        JsonUtils.parseObject(notes);

        return null;
    }
}
