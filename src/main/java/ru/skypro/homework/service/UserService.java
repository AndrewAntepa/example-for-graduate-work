package ru.skypro.homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.component.AuthenticationFacade;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;

import java.io.*;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade; // компонент для получения текущего пользователя

    public UserService(UserRepository userRepository, AuthenticationFacade authenticationFacade) {
        this.userRepository = userRepository;
        this.authenticationFacade = authenticationFacade;
    }

    public void updateUserImage(MultipartFile file) {
        User user = authenticationFacade.getCurrentUser(); // например, через SecurityContextHolder

        try {
            if (file == null || file.isEmpty()) {
                throw new RuntimeException("Файл не выбран или пустой");
            }
            user.setImage(file.getBytes());
            userRepository.save(user);
            byte[] bytes = file.getBytes();
            log.info("Изображение пользователя {} обновлено, размер: {} байт", user.getEmail(), bytes.length);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения изображения", e);
        }
    }

    public byte[] getUserImage() {
        User user = authenticationFacade.getCurrentUser();
        return user.getImage();
    }

    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    public UpdateUser updateUser(UpdateUser updateUser) {
        User user = authenticationFacade.getCurrentUser();
        if (user != null) {
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setPhone(updateUser.getPhone());
            userRepository.save(user);
            return updateUser;
        } else {
            return null;
        }
    }
}
