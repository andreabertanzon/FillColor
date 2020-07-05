package com.bertanzon;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class contains the logic of the game and the method needed to get, set and return all the values inside the
 * board. It is independent from the View
 */

public class FillColor {

    private Player currentPlayer;
    private ObservableList<Player> board = FXCollections.observableArrayList();



    FillColor() {
        currentPlayer = Player.RED;
        initializeBoard();



        board.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {

            }

        });

    }

    private void initializeBoard() {

        for (int i = 0; i <9 ; i++) {

            board.add(i,Player.WHITE);

        }


    }

    /**
     * checks grid positions to scan for a possible winner. If it finds a combination of grids position that is a
     * winning combo
     * @return the winning player or nobody.
     */
    public Player checkWinner() {

        if (board.get(0).equals(Player.RED) && board.get(1).equals(Player.RED) && board.get(2).equals(Player.RED) ||
                board.get(3).equals(Player.RED) && board.get(4).equals(Player.RED) && board.get(5).equals(Player.RED) ||
                board.get(6).equals(Player.RED) && board.get(7).equals(Player.RED) && board.get(8).equals(Player.RED) ||
                board.get(0).equals(Player.RED) && board.get(3).equals(Player.RED) && board.get(6).equals(Player.RED) ||
                board.get(1).equals(Player.RED) && board.get(4).equals(Player.RED) && board.get(7).equals(Player.RED) ||
                board.get(2).equals(Player.RED) && board.get(5).equals(Player.RED) && board.get(8).equals(Player.RED) ||
                board.get(0).equals(Player.RED) && board.get(4).equals(Player.RED) && board.get(8).equals(Player.RED) ||
                board.get(2).equals(Player.RED) && board.get(4).equals(Player.RED) && board.get(6).equals(Player.RED)) {
            return Player.RED;

        } else if (board.get(0).equals(Player.GREEN) && board.get(1).equals(Player.GREEN) && board.get(2).equals(Player.GREEN) ||
                board.get(3).equals(Player.GREEN) && board.get(4).equals(Player.GREEN) && board.get(5).equals(Player.GREEN) ||
                board.get(6).equals(Player.GREEN) && board.get(7).equals(Player.GREEN) && board.get(8).equals(Player.GREEN) ||
                board.get(0).equals(Player.GREEN) && board.get(3).equals(Player.GREEN) && board.get(6).equals(Player.GREEN) ||
                board.get(1).equals(Player.GREEN) && board.get(4).equals(Player.GREEN) && board.get(7).equals(Player.GREEN) ||
                board.get(2).equals(Player.GREEN) && board.get(5).equals(Player.GREEN) && board.get(8).equals(Player.GREEN) ||
                board.get(0).equals(Player.GREEN) && board.get(4).equals(Player.GREEN) && board.get(8).equals(Player.GREEN) ||
                board.get(2).equals(Player.GREEN) && board.get(4).equals(Player.GREEN) && board.get(6).equals(Player.GREEN)) {
            return Player.GREEN;
        }
        return Player.WHITE;

    }
/**
 * given a position and Player value, it adds the value inside the index position.
 */
    public void setBoardValue(int index, Player value){
        board.set(index,value);
    }

    public boolean gameOver(){
        if ((checkWinner().equals(Player.RED))||(checkWinner().equals(Player.GREEN)))
            return true;
        return false;
    }

    /**
     * gets the current player.
     * @return currentPlayer variable that stores who is the current player
     */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * switches between the players of the game
     * @return hte new current player
     */
    public Player switchCurrentPlayer(){
        if (getCurrentPlayer().equals(Player.RED)) {
            currentPlayer = Player.GREEN;
            return currentPlayer;
        }
        else if (getCurrentPlayer().equals(Player.GREEN)) {
            currentPlayer = Player.RED;
            return currentPlayer;
        }
        return Player.WHITE;
    }

    /**
     * gets the board status and
     * @return the board so the state of the board.
     */
    public ObservableList<Player> getBoard(){
        return board;
    }

    /**
     * clears the entire board resetting the game to prepare it for another round.
     */
    public void clear() {
        for (int i = 0; i <9 ; i++) {
            setBoardValue(i,Player.WHITE);

        }
    }


}
