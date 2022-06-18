package me.dio.santander.domain;

import java.time.Instant;

public abstract class Entity {

    private String id;
    private final Instant createdAt;
    protected Instant updatedAt;

    protected Entity(final String id) {
        this.id = id;
        this.createdAt = Instant.now();
    }

    public abstract void validate();

    public String id() {
        return id;
    }

    public Instant createdAt() {
        return createdAt;
    }

    public Instant updatedAt() {
        return updatedAt;
    }

}
