package com.example.finaleAssignment.model;

import jakarta.persistence.*;


@Entity
public class Albums {
    @Column
    private Long user_id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;

    public Albums() {
    }

    public Albums(Long userId, String title) {
        this.user_id = userId;
        this.title = title;
    }

    public Long getUser_id() {
        return (long) user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = (long) user_id;
    }

    public Long getId() {
        return (long) id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
