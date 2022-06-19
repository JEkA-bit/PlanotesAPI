package net.planotes.model.mongo;

import com.mongodb.lang.NonNull;
import net.planotes.model.Item;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Login extends Item {

    @NonNull
    private String user;
    @NonNull
    private String loginIP;
    @NonNull
    private String deviceName;
    @NonNull
    private boolean isOpen;

    public Login() {
    }

    public Login(String name,
                 @NonNull String user,
                 @NonNull String loginIP,
                 @NonNull String deviceName,
                 @NonNull boolean isOpen,
                 String description,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt) {
        super(name, description, createdAt, updatedAt);
        this.user = user;
        this.loginIP = loginIP;
        this.deviceName = deviceName;
        this.isOpen = isOpen;
    }

    public Login(String id,
                 String name,
                 @NonNull String user,
                 @NonNull String loginIP,
                 @NonNull String deviceName,
                 @NonNull boolean isOpen,
                 String description,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt) {
        super(id, name, description, createdAt, updatedAt);
        this.user = user;
        this.loginIP = loginIP;
        this.deviceName = deviceName;
        this.isOpen = isOpen;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    public void setUser(@NonNull String user) {
        this.user = user;
    }

    @NonNull
    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(@NonNull String loginIP) {
        this.loginIP = loginIP;
    }

    @NonNull
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(@NonNull String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
