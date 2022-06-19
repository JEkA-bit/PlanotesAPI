package net.planotes.model.mongo;

import net.planotes.model.Person;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class User extends Person {


    private String email;
    private String password;
    private String activationCode;

    public User() {
    }

    public User(String name,
                String description,
                LocalDateTime createdAt,
                LocalDateTime updatedAt,
                String middlename,
                String lastname,
                boolean gender,
                LocalDate birthday,
                String email,
                String password,
                String activationCode) {
        super(name, description, createdAt, updatedAt, middlename, lastname, gender, birthday);
        this.email = email;
        this.password = password;
        this.activationCode = activationCode;
    }

    public User(String id,
                String name,
                String description,
                LocalDateTime createdAt,
                LocalDateTime updatedAt,
                String middlename,
                String lastname,
                String country,
                String city,
                boolean gender,
                LocalDate birthday,
                String email,
                String password,
                String activationCode) {
        super(id, name, description, createdAt, updatedAt, middlename, lastname, gender, birthday);
        this.email = email;
        this.password = password;
        this.activationCode = activationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", middlename='" + super.getMiddlename() + '\'' +
                ", lastname='" + super.getLastname() + '\'' +
                ", gender=" + super.isGender() +
                ", birthday=" + super.getBirthday() +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", createdAt=" + super.getCreatedAt() +
                ", updatedAt=" + super.getUpdatedAt() +
                '}';
    }
}
