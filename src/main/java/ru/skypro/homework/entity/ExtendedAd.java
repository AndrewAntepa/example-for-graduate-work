package ru.skypro.homework.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ConstructorBinding
public class ExtendedAd {
    @Id
    @NotNull
    private int pk;
    @NotNull
    private String authorFirstName;
    @NotNull
    private String authorLastName;
    @NotNull
    private String description;
    @NotNull
    private String email;
    @NotNull
    private String image;
    @NotNull
    private String phone;
    @NotNull
    private int price;
    @NotNull
    private String title;


}
