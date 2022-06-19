package net.planotes.model.mongo;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import jdk.jfr.BooleanFlag;
import net.planotes.model.Item;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Note extends Item {

    @NonNull
    private User user;
    @Nullable
    private Note parentNote;
    @BooleanFlag
    private boolean archived;


    public Note() {
    }

    public Note(String name,
                User user,
                Note note,
                boolean archived,
                String description,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {
        super(name, description, createdAt, updatedAt);
        this.user = user;
        this.parentNote = note;
        this.archived = archived;
    }

    public Note(String id,
                String name,
                User user,
                Note note,
                boolean archived,
                String description,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {
        super(id, name, description, createdAt, updatedAt);
        this.user = user;
        this.parentNote = note;
        this.archived = archived;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getParentNote() {
        return parentNote;
    }

    public void setParentNote(Note note) {
        this.parentNote = note;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + super.getId() + '\'' +
                ", user=" + user +
                ", note=" + parentNote +
                ", archived=" + archived +
                ", name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", createdAt=" + super.getCreatedAt() +
                ", updatedAt=" + super.getUpdatedAt() +
                '}';
    }
}
