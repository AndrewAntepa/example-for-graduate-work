package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.component.AuthenticationFacade;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.repository.AdRepository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    private final AdRepository adRepository;
    private final AuthenticationFacade authenticationFacade;

    public AdService(AdRepository adRepository, AuthenticationFacade authenticationFacade) {
        this.adRepository = adRepository;
        this.authenticationFacade = authenticationFacade;
    }

    public List<Ad> getAllAds() {
        if (adRepository.findAll().isEmpty()) {
            return new ArrayList<Ad>();
        } else {
            return adRepository.findAll();
        }
    }

    public Ad addAd(CreateOrUpdateAd adDto, MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                throw new RuntimeException("Файл не выбран или пустой");
            }

            BufferedImage originalImage = ImageIO.read(file.getInputStream());
            if (originalImage == null) {
                throw new RuntimeException("Неверный формат изображения");
            }

            int targetWidth = 300;
            int targetHeight = 300;

            Image scaledInstance = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            BufferedImage scaledImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(scaledInstance, 0, 0, null);
            g2d.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(scaledImage, "jpg", baos);
            byte[] scaledBytes = baos.toByteArray();

            Ad ad = new Ad();
            ad.setAuthor(authenticationFacade.getCurrentUser().getId());
//            ad.setAuthor(4);
            ad.setTitle(adDto.getTitle());
            ad.setPrice(adDto.getPrice());
            ad.setImage(scaledBytes);

            return adRepository.save(ad);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения изображения", e);
        }
    }

    public Ad getAdById(int id) {
        return adRepository.getReferenceById(id);
    }
}

