package com.lavadero.controllers;

import java.io.IOException;

import com.lavadero.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
