package com.example.finaleAssignment.services;

import com.example.finaleAssignment.Repository.PhotosRepository;
import com.example.finaleAssignment.model.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    private final PhotosRepository photoRepository;

    @Autowired
    public PhotosService(PhotosRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photos getPhotoById(Long photoId) {
        return photoRepository.findById(photoId)
                .orElseThrow(() -> new RuntimeException("Photo not found with id: " + photoId));
    }

    public List<Photos> getPhotosByAlbumId(Long albumId) {
        return photoRepository.findByAlbumId(albumId);
    }

    public Photos createPhoto(Photos photo) {
        return photoRepository.save(photo);
    }

    public Photos updatePhoto(Long photoId, Photos photo) {
        Photos existingPhoto = getPhotoById(photoId);
        existingPhoto.setTitle(photo.getTitle());
        // Set other fields as needed
        return photoRepository.save(existingPhoto);
    }

    public void deletePhoto(Long photoId) {
        photoRepository.deleteById(photoId);
    }
}
