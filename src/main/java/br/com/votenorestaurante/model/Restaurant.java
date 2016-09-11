package br.com.votenorestaurante.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.concurrent.atomic.AtomicLong;

public class Restaurant {

    private Long id;

    private String name;

    private String category;

    private String description;
    private String imageId;

    private final AtomicLong counter = new AtomicLong();


    public Restaurant(String name, String category, String description, String imageId) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageId = imageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
