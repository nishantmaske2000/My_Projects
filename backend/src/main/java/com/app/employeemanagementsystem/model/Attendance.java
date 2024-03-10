package com.app.employeemanagementsystem.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    private Integer logHours;

    private Boolean approved=false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Attendance() {
    }

    public Attendance(Long id, LocalDate date, String description, Integer logHours, Boolean approved, User user) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.logHours = logHours;
        this.approved = approved;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLogHours() {
        return logHours;
    }

    public void setLogHours(Integer logHours) {
        this.logHours = logHours;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", logHours=" + logHours +
                ", approved=" + approved +
                ", user=" + user +
                '}';
    }
}
