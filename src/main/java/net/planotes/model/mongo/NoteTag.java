package net.planotes.model.mongo;

import net.planotes.model.Item;

import java.time.LocalDateTime;

public class NoteTag extends Item {

    private String NoteId;
    private String TagId;

    public NoteTag() {
    }

    public NoteTag(LocalDateTime createdAt,
                   LocalDateTime updatedAt,
                   String noteId,
                   String tagId) {
        super(createdAt, updatedAt);
        NoteId = noteId;
        TagId = tagId;
    }

    public String getNoteId() {
        return NoteId;
    }

    public void setNoteId(String noteId) {
        NoteId = noteId;
    }

    public String getTagId() {
        return TagId;
    }

    public void setTagId(String tagId) {
        TagId = tagId;
    }
}
