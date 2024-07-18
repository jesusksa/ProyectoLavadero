package com.lavadero.controllers;

import java.io.IOException;

import com.lavadero.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}