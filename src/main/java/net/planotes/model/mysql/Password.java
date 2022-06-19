package net.planotes.model.mysql;

import com.mongodb.lang.NonNull;
import net.planotes.model.Item;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Password extends Item {

    @NonNull
    private String userId;
    @NonNull
    private String password;

    public Password() {
    }

    public Password(LocalDateTime createdAt,
                    LocalDateTime updatedAt,
                    @NonNull String userId,
                    @NonNull String password) {
        super(createdAt, updatedAt);
        this.userId = userId;
        this.password = password;
    }

    public Password(String id,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt,
                    @NonNull String userId,
                    @NonNull String password) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.password = password;
    }

    @NonNull
    public String getUser() {
        return userId;
    }

    public void setUser(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
