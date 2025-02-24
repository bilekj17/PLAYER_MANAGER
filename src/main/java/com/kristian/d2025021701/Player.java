package com.kristian.d2025021701;

public class Player {
    private String username;
    private int level;
    private PlayerClass playerClass;
    private String email;
    private long registered;

    public Player(String username, int level, PlayerClass playerClass, String email, long registered) {
        this.username = username;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registered = registered;
    }
    public Player(String username, String email) {
        this.username = username;
        this.email = email;
        this.registered = System.currentTimeMillis();
    }
}
