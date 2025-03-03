package com.kristian.d2025021701;

import java.time.LocalDate;

public class Player {
    private String username;
    private int level;
    private PlayerClass playerClass;
    private String email;
    private LocalDate registered;

    public Player(String username, int level, PlayerClass playerClass, String email, LocalDate registered) {
        this.username = username;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registered = registered;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistered() {
        return registered;
    }
}
