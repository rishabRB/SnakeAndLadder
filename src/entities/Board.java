package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Integer BoardSize;
    private List<Snake> snake;
    private List<Ladder> ladder;
    private Map<String,Integer> playerPosition;


    public Board(int size) {
        this.BoardSize = size;
        this.snake = new ArrayList<>();
        this.ladder = new ArrayList<>();
        this.playerPosition = new HashMap<>();
    }

    public Integer getBoardSize() {
        return BoardSize;
    }

    public List<Snake> getSnake() {
        return snake;
    }

    public List<Ladder> getLadder() {
        return ladder;
    }

    public Integer getPlayerPosition(String id){
        return playerPosition.get(id);
    }
    public void setPlayerCurrentPosition(String id , Integer position){
        playerPosition.put(id,position);
    }


    public void setSnake(List<Snake> snake) {
        this.snake = snake;
    }

    public void setLadder(List<Ladder> ladder) {
        this.ladder = ladder;
    }

    public void setPlayerPosition(Map<String, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }



}
