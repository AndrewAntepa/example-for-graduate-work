package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
public class Comment {
    @NotNull
    private int author;
    @NotNull
    private String authorImage;
    @NotNull
    private String authorFirstName;
    @NotNull
    private Date createdAt;
    @Id
    @NotNull
    private int pk;
    @NotNull
    private String text;

    public Comment(int author, String authorImage, String authorFirstName, Date createdAt, int pk, String text) {
        this.author = author;
        this.authorImage = authorImage;
        this.authorFirstName = authorFirstName;
        this.createdAt = createdAt;
        this.pk = pk;
        this.text = text;
    }

    public Comment() {}
}
