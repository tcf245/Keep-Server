package com.keep.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tcf24 on 2016/4/11.
 */
@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TAGS_NOTES",
            joinColumns = @JoinColumn(name = "TAG_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "NOTE_ID", nullable = false))
    private List<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        return title.equals(tag.title);

    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", notes=" + notes +
                '}';
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
