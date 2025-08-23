package ru.skypro.homework.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.internal.javac.NoPreview;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Ad {
    @NotNull
    private int author;
    @NotNull
    private String image;
    @Id
    @NotNull
    private int pk;
    @NotNull
    private int price;
    @NotNull
    private String title;

    public Ad(int author, String image, int pk, int price, String title) {
        this.author = author;
        this.image = image;
        this.pk = pk;
        this.price = price;
        this.title = title;
    }

    public Ad() {}
}
