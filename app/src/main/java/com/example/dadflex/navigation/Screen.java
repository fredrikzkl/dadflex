package com.example.dadflex.navigation;

public abstract class Screen {
    public final String route;

    public Screen(String route) {
        this.route = route;
    }

    public static final Screen MenuScreen = new Screen("menu_screen") {};
    public static final Screen GameScreen = new Screen("game_screen") {};
    public static final Screen HighscoreScreen = new Screen("highscore_screen") {};
    public static final Screen OptionsScreen = new Screen("options_screen") {};
}

