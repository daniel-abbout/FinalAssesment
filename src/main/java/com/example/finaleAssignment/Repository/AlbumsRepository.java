package com.example.finaleAssignment.Repository;

import com.example.finaleAssignment.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumsRepository extends JpaRepository<Albums, Long> {
    List<Albums> findByUserId(Long userId);

}
