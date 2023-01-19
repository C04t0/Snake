package com.snake;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    private final int numOfRows = 15;
    private final int numOfColumns = 15;

    private TimerTask tt = new TimerTask()  {
        @Override
        public void run() {
            System.out.println("test2");
        }
    };

    @FXML
    private MenuItem closeButton;
    @FXML
    private MenuItem newGameButton;
    @FXML
    private GridPane playingField;
    private Rectangle[][] boardElements = new Rectangle[numOfRows][numOfColumns];

    @FXML
    void closeButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Closing game");

    }

    @FXML
    void newGameButtonClicked(ActionEvent event) {

    }

    private void intializeArray() {
    boardElements = new Rectangle[numOfRows][numOfColumns];
        for (Node node: playingField.getChildren()) {
            System.out.println(GridPane.getRowIndex(node));
            boardElements[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Rectangle) node;
        }
    }
    public void fillBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                playingField.add(new Rectangle(45, 45), i, j);
            }
        }
    }
    public void initialize() {
        fillBoard();
        intializeArray();
        Timer timer = new Timer();
        timer.schedule(tt, 2000, 1000);

    }
}