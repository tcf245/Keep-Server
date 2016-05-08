package com.keep.service;

import com.keep.dao.NoteDao;
import com.keep.domain.Note;
import com.keep.domain.User;

import java.util.List;

/**
 * Created by BFD_303 on 2016/4/28.
 */
public class NoteService {

    private NoteDao noteDao;

    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getAll(User user){
        return noteDao.findAll(user);
    }

    public void createNote(Note note){
        noteDao.save(note);
    }

    public void update(Note note){
        noteDao.update(note);
    }

    public Note get(int id ){
       return  noteDao.get(id);
    }

    public  void del (Note note){

         noteDao.delete(note);
    }
}
