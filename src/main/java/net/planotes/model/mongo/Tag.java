package net.planotes.model.mongo;

import net.planotes.model.Item;

import java.time.LocalDateTime;

public class Tag extends Item {

    private int amountOfUses;

    public Tag() {
    }

    public Tag(String id,
               String name,
               String description,
               int amountOfUses,
               LocalDateTime createdAt,
               LocalDateTime updatedAt) {
        super(id, name, description, createdAt, updatedAt);
        this.amountOfUses = amountOfUses;
    }

    public int getAmountOfUses() {
        return amountOfUses;
    }

    public void setAmountOfUses(int amountOfUses) {
        this.amountOfUses = amountOfUses;
    }
}
