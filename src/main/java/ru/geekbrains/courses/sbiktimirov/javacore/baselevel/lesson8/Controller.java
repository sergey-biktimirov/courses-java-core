package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson8;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.nextRandomInt;

public class Controller {

    @FXML
    private TextField randomResultTextField;
    @FXML
    private TextField minRandomValueTextField;
    @FXML
    private TextField maxRandomValueTextField;
    @FXML
    private Button nextRandomButton;

    public void init() {
        minRandomValueTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                try {
                    minRandomValueTextField.textProperty().set(String.valueOf(Integer.parseInt(newValue)));
                } catch (Exception e) {
                    minRandomValueTextField.textProperty().set(oldValue);
                }
            }
        });

        maxRandomValueTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                try {
                    maxRandomValueTextField.textProperty().set(String.valueOf(Integer.parseInt(newValue)));
                } catch (Exception e) {
                    maxRandomValueTextField.textProperty().set(oldValue);
                }
            }
        });

        nextRandomButton.setOnAction(actionEvent -> {
            randomResultTextField.textProperty().set(String.valueOf(nextRandomInt(getMinValue(), getMaxValue())));
        });
    }

    private int getMinValue() {
        return Integer.parseInt(minRandomValueTextField.textProperty().get());
    }

    private int getMaxValue() {
        return Integer.parseInt(maxRandomValueTextField.textProperty().get());
    }
}
