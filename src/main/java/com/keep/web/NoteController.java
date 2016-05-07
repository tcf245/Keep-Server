package com.keep.web;

import com.alibaba.fastjson.JSON;
import com.keep.domain.MessageBean;
import com.keep.domain.Note;
import com.keep.domain.User;
import com.keep.service.NoteService;
import com.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by tcf24 on 2016/5/7.
 */
@RestController
public class NoteController {

    @Autowired
    public NoteService noteService;
    @Autowired
    private UserService userService;

    @RequestMapping("/noteList")
    public String listAllNote(@RequestParam("token") String token){
        User u = new User();
        u.setToken(token);
        User tmp =userService.findUser(u);
        List<Note> lists = tmp.getNotes();
        MessageBean mb = new MessageBean();
        mb.setFlag(true);
        mb.setData(lists);
        return JSON.toJSONString(mb);

    }
    @RequestMapping("/noteView/{id}")
    public String view (@PathVariable("id") int id){
        Note  note = noteService.get(id);
        return JSON.toJSONString(note);
    }

    @RequestMapping("/noetDel/{id}")
    public  String del(@PathVariable("id") int id){

        Note note = noteService.get(id);
        MessageBean mb = new MessageBean();
        mb.setFlag(true);
        return JSON.toJSONString(mb);
    }

    @RequestMapping("/noteEdit/{id}")
    public  String edit(HttpServletRequest req , @PathVariable("id")int id){
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int color = Integer.parseInt(req.getParameter("color"));

        Note note = noteService.get(id);
        note.setContent(content);
        note.setTitle(title);
        note.setColor(color);
        note.setUpdate_time(new Date());
        noteService.update(note);

        MessageBean mb = new MessageBean();
        mb.setFlag(true);

        return JSON.toJSONString(mb);

    }
    @RequestMapping("/note/add")
    public  String  add(Note note , MultipartFile file ,HttpServletRequest request){
        User tmp = new  User();
        tmp.setToken(request.getParameter("token"));
        User u = userService.findUser(tmp);

        String filePath = request.getSession().getServletContext().getRealPath("/noteFile");


        File dirFile = new File(filePath);
        if(!dirFile.exists()){
            dirFile.mkdir();
            System.out.println("dirFile path : " + dirFile.getPath());
        }

        String fileName = file.getOriginalFilename();

        System.out.println( "fileName : " + fileName);
        String newFileName = System.currentTimeMillis()
                            +fileName.substring(fileName.indexOf("."),fileName.length());

        try {
            file.transferTo(new File(dirFile+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        note.setCreate_time(new Date());
        note.setPic("noteFile/"+newFileName);
        note.setOwner(u);
        noteService.createNote(note);
        MessageBean mb = new MessageBean();
                mb.setFlag(true);
        return JSON.toJSONString(mb);
    }
}
