package com.kristian.d2025021701;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlayerEditController {
    private Player player = null;

    @FXML
    protected TextField name;

    @FXML
    protected Spinner<Integer> spinner;

    @FXML
    protected ToggleButton bojovnik;
    @FXML
    protected ToggleButton mag;
    @FXML
    protected ToggleButton strelec;

    @FXML
    protected DatePicker date;


    @FXML
    protected void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        spinner.setValueFactory(valueFactory);
    }

    public Player getPlayer() {
        return player;
    }

    @FXML
    protected void save() {
        PlayerClass role = null;
        if (bojovnik.isSelected()) {
            role = PlayerClass.FIGHTER;
        }
        if (mag.isSelected()) {
            role = PlayerClass.MAGE;
        }
        if (strelec.isSelected()) {
            role = PlayerClass.ARCHER;
        }

        player = new Player(name.getText(), spinner.getValue(), role, null, date.getValue());
        name.getScene().getWindow().hide();

        if (player != null) {

        }
    }
    @FXML
    protected void close() {
        name.getScene().getWindow().hide();
    }
}
