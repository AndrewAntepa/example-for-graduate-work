package ru.skypro.homework.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.CommentDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.ExtendedAd;
import ru.skypro.homework.entity.User;

import java.util.Date;

@Mapper
public interface MapperInterface {
    MapperInterface INSTANCE = Mappers.getMapper(MapperInterface.class);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "role", source = "user.role")
    @Mapping(target = "image", source = "user.image")
    UserDTO userToUserDto(User user);

    @Mapping(target = "id", source = "userDTO.id")
    @Mapping(target = "email", source = "userDTO.email")
    @Mapping(target = "firstName", source = "userDTO.firstName")
    @Mapping(target = "lastName", source = "userDTO.lastName")
    @Mapping(target = "phone", source = "userDTO.phone")
    @Mapping(target = "role", source = "userDTO.role")
    @Mapping(target = "image", source = "userDTO.image")
    User UserDtoToUser(UserDTO userDTO);

    @Mapping(target = "author", source = "ad.author")
    @Mapping(target = "image", source = "ad.image")
    @Mapping(target = "pk", source = "ad.pk")
    @Mapping(target = "price", source = "ad.price")
    @Mapping(target = "title", source = "ad.title")
    AdDTO adToAdDto(Ad ad);

    @Mapping(target = "author", source = "adDTO.author")
    @Mapping(target = "image", source = "adDTO.image")
    @Mapping(target = "pk", source = "adDTO.pk")
    @Mapping(target = "price", source = "adDTO.price")
    @Mapping(target = "title", source = "adDTO.title")
    Ad adDtoToAd(AdDTO adDTO);

    @Mapping(target = "author", source = "comment.author")
    @Mapping(target = "authorImage", source = "comment.authorImage")
    @Mapping(target = "authorFirstName", source = "comment.authorFirstName")
    @Mapping(target = "createdAt", source = "comment.createdAt")
    @Mapping(target = "pk", source = "comment.pk")
    @Mapping(target = "text", source = "comment.text")
    CommentDTO commentToCommentDto(Comment comment);

    @Mapping(target = "author", source = "comment.author")
    @Mapping(target = "authorImage", source = "comment.authorImage")
    @Mapping(target = "authorFirstName", source = "comment.authorFirstName")
    @Mapping(target = "createdAt", source = "comment.createdAt")
    @Mapping(target = "pk", source = "comment.pk")
    @Mapping(target = "text", source = "comment.text")
    Comment commentDtoToComment(CommentDTO commentDTO);

    @Mapping(target = "pk", expression = "extendedAd.pk")
    @Mapping(target = "authorFirstName", expression = "extendedAd.authorFirstName")
    @Mapping(target = "authorLastName", expression = "extendedAd.authorLastName")
    @Mapping(target = "description", expression = "extendedAd.description")
    @Mapping(target = "email", expression = "extendedAd.email")
    @Mapping(target = "image", expression = "extendedAd.image")
    @Mapping(target = "phone", expression = "extendedAd.phone")
    @Mapping(target = "price", expression = "extendedAd.price")
    @Mapping(target = "title", expression = "extendedAd.title")
    ExtendedAdDTO extendedAdToExtendedAdDto(ExtendedAd extendedAd);

    @Mapping(target = "pk", expression = "extendedAdDTO.pk")
    @Mapping(target = "authorFirstName", expression = "extendedAdDTO.authorFirstName")
    @Mapping(target = "authorLastName", expression = "extendedAdDTO.authorLastName")
    @Mapping(target = "description", expression = "extendedAdDTO.description")
    @Mapping(target = "email", expression = "extendedAdDTO.email")
    @Mapping(target = "image", expression = "extendedAdDTO.image")
    @Mapping(target = "phone", expression = "extendedAdDTO.phone")
    @Mapping(target = "price", expression = "extendedAdDTO.price")
    @Mapping(target = "title", expression = "extendedAdDTO.title")
    ExtendedAd extendedAdDtoToExtendedAd(ExtendedAdDTO extendedAdDTO);

}
