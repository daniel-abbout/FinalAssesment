package com.example.finaleAssignment.services;


import com.example.finaleAssignment.Repository.AlbumsRepository;
import com.example.finaleAssignment.model.Albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumsRepository albumRepository;

    @Autowired
    public AlbumService(AlbumsRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Albums getAlbumById(Long albumId) {
        return albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album not found with id: " + albumId));
    }

    public List<Albums> getAlbumsByUserId(Long userId) {
        return albumRepository.findByUserId(userId);
    }

    public Albums createAlbum(Albums album) {
        return albumRepository.save(album);
    }

    public Albums updateAlbum(Long albumId, Albums album) {
        Albums existingAlbum = getAlbumById(albumId);
        existingAlbum.setTitle(album.getTitle());

        return albumRepository.save(existingAlbum);
    }


    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
