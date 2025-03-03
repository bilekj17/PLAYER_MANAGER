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
            players.getItems().add(new Player("kristian", 15, PlayerClass.FIGHTER, "nekdo@neco.cz", LocalDate.of(2020, 1, 1)));
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
        protected void deletePlayer() {
            players.getItems().remove(players.getSelectionModel().getSelectedItem());
        }
        @FXML
        protected void editPlayer() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditPlayer.fxml"));
            try {
                VBox form = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                form = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            PlayerEditController controller = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Edit Player");
            stage.setScene(new Scene(form));
            stage.showAndWait();

            Player player = controller.getPlayer();

            if (player == null) {
                return;
            }

            players.getItems().add(controller.getPlayer());

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
