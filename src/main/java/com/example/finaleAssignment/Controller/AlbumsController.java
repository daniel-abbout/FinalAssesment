package com.example.finaleAssignment.Controller;

import com.example.finaleAssignment.model.Albums;
import com.example.finaleAssignment.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final AlbumService albumService;

    @Autowired
    public AlbumsController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Albums> getAlbumById(@PathVariable Long albumId) {
        Albums album = (Albums) albumService.getAlbumById(albumId);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Albums>> getAlbumsByUserId(@PathVariable Long userId) {
        List<Albums> albums = albumService.getAlbumsByUserId(userId);
        return ResponseEntity.ok(albums);
    }

    @PostMapping
    public ResponseEntity<Albums> createAlbum(@RequestBody Albums album) {
        Albums createdAlbum = albumService.createAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlbum);
    }

    @PutMapping("/{albumId}")
    public ResponseEntity<Albums> updateAlbum(@PathVariable Long albumId, @RequestBody Albums album) {
        Albums updatedAlbum = albumService.updateAlbum(albumId, album);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/{albumId}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbum(albumId);
        return ResponseEntity.noContent().build();
    }
}
