
package com.example.finaleAssignment.services;

import com.example.finaleAssignment.model.Albums;
import com.example.finaleAssignment.model.Photos;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GalleryImportService {

    private final RestTemplate restTemplate;

    private final AlbumService albumService;
    private final PhotosService photoService;


    public GalleryImportService(RestTemplate restTemplate, AlbumService albumService, PhotosService photoService) {
        this.restTemplate = restTemplate;
        this.albumService = albumService;
        this.photoService = photoService;
    }

    @Async
    public CompletableFuture<Void> importUserGallery() {
        List<Albums> albums = Arrays.asList(restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", Albums[].class));
        albums.forEach(album -> {
            Albums createdAlbum = albumService.createAlbum(album);
            List<Photos> photos = Arrays.asList(restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos?albumId=" + album.getId(), Photos[].class));
            photos.forEach(photo -> {
                photo.setAlbum(createdAlbum);
                photoService.createPhoto(photo);
            });
        });
        return CompletableFuture.completedFuture(null);
    }
}
