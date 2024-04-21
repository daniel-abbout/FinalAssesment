package com.example.finaleAssignment.Controller;

import com.example.finaleAssignment.model.Photos;
import com.example.finaleAssignment.services.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    private final PhotosService photoService;

    public PhotosController(PhotosService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/{photoId}")
    public ResponseEntity<Photos> getPhotoById(@PathVariable Long photoId) {
        Photos photo = photoService.getPhotoById(photoId);
        return ResponseEntity.ok(photo);
    }

    @GetMapping("/album/{albumId}")
    public ResponseEntity<List<Photos>> getPhotosByAlbumId(@PathVariable Long albumId) {
        List<Photos> photos = photoService.getPhotosByAlbumId(albumId);
        return ResponseEntity.ok(photos);
    }

    @PostMapping
    public ResponseEntity<Photos> createPhoto(@RequestBody Photos photo) {
        Photos createdPhoto = photoService.createPhoto(photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoto);
    }

    @PutMapping("/{photoId}")
    public ResponseEntity<Photos> updatePhoto(@PathVariable Long photoId, @RequestBody Photos photo) {
        Photos updatedPhoto = photoService.updatePhoto(photoId, photo);
        return ResponseEntity.ok(updatedPhoto);
    }

    @DeleteMapping("/{photoId}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long photoId) {
        photoService.deletePhoto(photoId);
        return ResponseEntity.noContent().build();
    }
}
