package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Ad;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.service.AdService;

@RestController
@RequestMapping("/ads")
public class AdController {
    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public Ads getAllAds() {
        return new Ads();
    }

    @PostMapping
    public Ad addAd(@RequestBody CreateOrUpdateAd ad, @RequestBody String image) {
        return new Ad();
    }

    @GetMapping("/{id}")
    public Ad getAd(@PathVariable int id) {
        return new Ad();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    public CreateOrUpdateAd updateAd(@PathVariable int id) {
        return new CreateOrUpdateAd();
    }

    @GetMapping("/me")
    public Ads getMyAds() {
        return new Ads();
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<?> updateImage(@PathVariable int id, @RequestBody String image) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
