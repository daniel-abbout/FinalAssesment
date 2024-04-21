package com.example.finaleAssignment.Controller;


import com.example.finaleAssignment.services.GalleryImportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private final GalleryImportService galleryImportService;


    public UsersController(GalleryImportService galleryImportService) {
        this.galleryImportService = galleryImportService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> importUsersGalleries() {
        try {
            galleryImportService.importUserGallery();
            return ResponseEntity.ok("Importing users' galleries started successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to start importing users' galleries: " + e.getMessage());
        }
    }
}
