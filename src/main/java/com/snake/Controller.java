package com.snake;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    private final int numOfRows = 15;
    private final int numOfColumns = 15;

    private TextInputControlSkin.Direction direction = TextInputControlSkin.Direction.RIGHT;

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

    @FXML
    private AnchorPane anchorPane;


    public Node[][] boardElements = new Node[numOfRows][numOfColumns];

    private Rectangle snakeFood = new Rectangle(30, 30, Color.BLUE);

    private Rectangle snakeHead = new Rectangle(30, 30 , Color.RED);

    private Rectangle snakeTail = new Rectangle(30, 30, Color.BLACK);

    private ArrayList<Rectangle> fullSnake = new ArrayList<>();
    @FXML
    void closeButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Closing game");

    }

    @FXML
    void newGameButtonClicked(ActionEvent event) {

    }
    @FXML
    void moveSquareKeyPressed(KeyEvent event) {
        if(event.getCode().equals(KeyCode.Z) && direction != TextInputControlSkin.Direction.DOWN){
            direction = TextInputControlSkin.Direction.UP;
        } else if(event.getCode().equals(KeyCode.S) && direction != TextInputControlSkin.Direction.UP){
            direction = TextInputControlSkin.Direction.DOWN;
        }else if(event.getCode().equals(KeyCode.Q) && direction != TextInputControlSkin.Direction.RIGHT){
            direction = TextInputControlSkin.Direction.LEFT;
        }else if(event.getCode().equals(KeyCode.D) && direction != TextInputControlSkin.Direction.LEFT){
            direction = TextInputControlSkin.Direction.RIGHT;
        }
    }

    public void fillBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                playingField.add(new Rectangle(45, 45), i, j);
            }
        }
    }

    private void intializeArray() {
    boardElements = new Rectangle[numOfRows][numOfColumns];
        for (Node node: playingField.getChildren()) {
            System.out.println(GridPane.getRowIndex(node));
            boardElements[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Rectangle) node;
        }
    }

    public void initialize() {
        fillBoard();
        intializeArray();
        fullSnake.add(snakeHead);
        Timer timer = new Timer();
        timer.schedule(tt, 2000, 1000);

        fullSnake.add(snakeTail);



    }
}