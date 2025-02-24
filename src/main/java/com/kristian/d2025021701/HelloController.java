package com.kristian.d2025021701;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private ListView<Player> players;
    @FXML
    private Label welcomeText;

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

    }
    @FXML
    protected void editPlayer() {

    }
}