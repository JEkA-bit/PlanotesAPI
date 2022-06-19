package net.planotes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public abstract class Person extends Item {
    private String middlename;
    private String lastname;
    private boolean gender;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String name,
                  String description,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  String middlename,
                  String lastname,
                  boolean gender,
                  LocalDate birthday) {
        super(name, description, createdAt, updatedAt);
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Person(String id,
                  String name,
                  String description,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  String middlename,
                  String lastname,
                  boolean gender,
                  LocalDate birthday) {
        super(id, name, description, createdAt, updatedAt);
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", description='" + super.getDescription() + '\'' +
                ", createdAt=" + super.getCreatedAt() +
                ", updatedAt=" + super.getUpdatedAt() +
                '}';
    }

}
