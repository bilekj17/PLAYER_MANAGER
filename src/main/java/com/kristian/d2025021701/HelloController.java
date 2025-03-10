package com.kristian.d2025021701;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloController {
        @FXML
        private ListView<Player> players;
        @FXML
        private Label welcomeText;

        @FXML
        public void initialize() {
            players.getItems().add(new Player("Honza", 15, PlayerClass.FIGHTER, "nekdo@neco.cz", LocalDate.of(2020, 1, 1)));
        }
        @FXML
        protected void deletePlayer() {
            players.getItems().remove(players.getSelectionModel().getSelectedItem());
        }
    @FXML
    protected void addPlayer() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerAdd.fxml"));
            VBox form = fxmlLoader.load();

            PlayerFormController controller = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Add Player");
            stage.setScene(new Scene(form));
            stage.showAndWait();

            Player player = controller.getPlayer();

            if (player == null) {
                return;
            }

            players.getItems().add(controller.getPlayer());

        } catch (IOException e) {
            //handle exception
        }
    }

    @FXML
    protected void editPlayer() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerAdd.fxml"));
            VBox form = fxmlLoader.load();

            PlayerFormController controller = fxmlLoader.getController();

            controller.setPlayer(players.getSelectionModel().getSelectedItem());
            controller.load();

            Stage stage = new Stage();
            stage.setTitle("edit Player");
            stage.setScene(new Scene(form));
            stage.showAndWait();

            Player player = controller.getPlayer();
        } catch (IOException e) {
            //handle exception
        }
    }


    @FXML
    protected void showPlayers() {
        Player player = players.getSelectionModel().getSelectedItem();
        String output = " username: " +player.getUsername();
        output += "\n level: " +player.getLevel();
        output += "\n class: " +player.getPlayerClass();
        output += "\n email: " +player.getEmail();
        output += "\n date: " +player.getRegistered();

        if (player.getLevel() >= 50){
            welcomeText.setTextFill(Paint.valueOf("red"));
        }
        if (player.getLevel() >= 20 && player.getLevel() <= 49){
            welcomeText.setTextFill(Paint.valueOf("blue"));
        }
        if (player.getLevel() >= 1 && player.getLevel() <=19){
            welcomeText.setTextFill(Paint.valueOf("green"));
        }
        welcomeText.setText(output);
    }
}
