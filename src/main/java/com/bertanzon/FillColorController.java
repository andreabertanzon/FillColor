package com.bertanzon;

import java.net.MulticastSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * Controller class for the FillColor Tic tac toe game. Links the FillColor logic/model to the User interface.
 */
public class FillColorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane grid;


    @FXML
    private Rectangle rect0;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    private Rectangle rect3;

    @FXML
    private Rectangle rect4;

    @FXML
    private Rectangle rect5;

    @FXML
    private Rectangle rect6;

    @FXML
    private Rectangle rect7;

    @FXML
    private Rectangle rect8;

    public FillColor game;



    @FXML
    void changeColor(MouseEvent event) {
        List board = game.getBoard();

        Rectangle object = (Rectangle) event.getTarget();
        int squareNumber = calculateSquareNumber(object);
        if (object.getFill().equals(Color.WHITE)) {
            if (game.getCurrentPlayer().equals(Player.RED)) {
                game.switchCurrentPlayer();
                object.setFill(Color.RED);
                game.setBoardValue(squareNumber, Player.RED);
            } else if (game.getCurrentPlayer().equals(Player.GREEN)) {
                object.setFill(Color.GREEN);
                game.setBoardValue(squareNumber, Player.GREEN);
                game.switchCurrentPlayer();

            } else {
                return;
            }
            Player temp = game.checkWinner();
            if (temp.equals(Player.RED)){
                game.clear();
                game.switchCurrentPlayer();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(rect0.getScene().getWindow());
                alert.setTitle("WINNER FOUND");
                alert.setContentText("RED WINS!!!!!!!!!!!!!");
                alert.showAndWait();
                emptyTiles();
            }else if (temp.equals(Player.GREEN)) {
                game.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(rect0.getScene().getWindow());
                alert.setTitle("WINNER FOUND");
                alert.setContentText("`GREEN WINS!!!!!!!!!!!!!");
                alert.showAndWait();
                emptyTiles();
            }
            if (!(board.contains(Player.WHITE))) {
                game.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(rect0.getScene().getWindow());
                alert.setTitle("NO WINNER");
                alert.setContentText("IT IS A TIE!");
                alert.showAndWait();
                emptyTiles();
                if (game.getCurrentPlayer().equals(Player.GREEN)){
                    game.switchCurrentPlayer();
                }
            }

        }

    }

    private void emptyTiles() {
        rect0.setFill(Color.WHITE);
        rect1.setFill(Color.WHITE);
        rect2.setFill(Color.WHITE);
        rect3.setFill(Color.WHITE);
        rect4.setFill(Color.WHITE);
        rect5.setFill(Color.WHITE);
        rect6.setFill(Color.WHITE);
        rect7.setFill(Color.WHITE);
        rect8.setFill(Color.WHITE);
    }

    private int calculateSquareNumber(Rectangle object) {
        if (object.equals(rect0)){
            return 0;
        }else if(object.equals(rect1)){
            return 1;
        } else if (object.equals(rect2)){
            return 2;
        }else if (object.equals(rect3)){
            return 3;
        }else if (object.equals(rect4)){
            return 4;
        }else if (object.equals(rect5)){
            return 5;
        }else if (object.equals(rect6)){
            return 6;
        }else if (object.equals(rect7)){
            return 7;
        }else if (object.equals(rect8)){
            return 8;
        }
        return 0;
    }


    @FXML
    void initialize() {

       game = new FillColor();

    }
}
