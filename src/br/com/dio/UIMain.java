package br.com.dio;

import br.com.dio.ui.custom.screen.MainScreen;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class UIMain {

    public static void main(String[] args) {
        String[] configSource = args.length > 0 ? args : 
                System.getenv().getOrDefault("SUDOKU_CONFIG", "").split(" ");

        final var gameConfig = Stream.of(configSource)
                .filter(s -> s.contains(";"))
                .collect(toMap(k -> k.split(";")[0], v -> v.split(";")[1]));
        var mainsScreen = new MainScreen(gameConfig);
        mainsScreen.buildMainScreen();
    }

}
