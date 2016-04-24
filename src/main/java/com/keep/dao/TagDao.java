package com.keep.dao;

import com.keep.domain.Tag;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tcf24 on 2016/4/11.
 */
@Transactional
public class TagDao {
    private HibernateTemplate template;

    public TagDao(HibernateTemplate template) {
        this.template = template;
    }

    public void save(Tag tag){
        template.save(tag);
    }

    public void update(Tag tag){
        template.update(tag);
    }

    public void delete(Tag tag){
        template.delete(tag);
    }

    public List<Tag> findAll(){
        List<Tag> tags = (List<Tag>) template.find("from Tag",Tag.class);
        return tags.isEmpty() ? null : tags;
    }

    public Tag findByName(String name){
        Tag tag = (Tag) template.find("from Tag where title = ?",name);
        return tag;
    }
}
