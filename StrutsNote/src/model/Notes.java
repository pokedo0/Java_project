package model;

import java.sql.Timestamp;

/**
 * Created by pokedo on 2017/4/14.
 */
public class Notes {
    private int noteId;
    private String title;
    private String content;
    private Timestamp pubTime;
    private User user;
    private String attachment;

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public User getUser() {
        return user;
    }

    public String getAttachment() {
        return attachment;
    }
}
