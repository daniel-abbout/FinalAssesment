package com.example.finaleAssignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Photos {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Albums album;
    private String title;
    private String url;
    private String thumbnail_url;

    public Photos(long l, String s, String url, Long albumId) {

    }

    public Photos(Long id, Albums album, String title, String url, String thumbnail_url) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.url = url;
        this.thumbnail_url = thumbnail_url;
    }

    public Photos() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }
}
