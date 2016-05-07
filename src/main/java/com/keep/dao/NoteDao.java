package com.keep.dao;

import com.keep.domain.Note;
import com.keep.domain.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tcf24 on 2016/4/11.
 */
@Transactional
public class NoteDao {
    private HibernateTemplate template;

    public NoteDao(HibernateTemplate template) {
        this.template = template;
    }

    public void save(Note note){
        template.save(note);
    }

    public void update(Note note){
        template.update(note);
    }

    public List<Note> findAll(User user){
        List<Note> notes =  (List<Note>) template.find("from Note where owner=? order by update_time DESC",user);
        return notes.isEmpty() ? null : notes;
    }

    public void delete(Note note){
        template.delete(note);
    }

    public Note get(int id ){
        return template.get(Note.class ,id);
    }
}
