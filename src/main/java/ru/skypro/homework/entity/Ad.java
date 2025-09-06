package ru.skypro.homework.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ad {
    @NotNull
    private int author;
    @NotNull
    private byte[] image;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;
    @NotNull
    private int price;
    @NotNull
    private String title;

    public Ad(int author, byte[] image, int price, String title) {
        this.author = author;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public Ad() {}

    @NotNull
    public int getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull int author) {
        this.author = author;
    }

    public @NotNull byte[] getImage() {
        return image;
    }

    public void setImage(@NotNull byte[] image) {
        this.image = image;
    }

    @NotNull
    public int getPk() {
        return pk;
    }

    @NotNull
    public int getPrice() {
        return price;
    }

    public void setPrice(@NotNull int price) {
        this.price = price;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }
}
