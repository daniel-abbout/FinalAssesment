package com.example.finaleAssignment.Repository;

import com.example.finaleAssignment.model.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, Long> {

    List<Photos> findByAlbumId(Long albumId);
}
