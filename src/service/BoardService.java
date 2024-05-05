package service;

import entities.Board;
import entities.Ladder;
import entities.Player;
import entities.Snake;

import javax.naming.InitialContext;
import java.util.*;

public class BoardService {
    private Board board;
    private Queue<Player> players;
    private boolean isGameComplete;

    private final Integer default_board_size = 100;

    public BoardService() {
        this.board = new Board(default_board_size);
        this.players = new LinkedList<>();
    }

    public void setSnakeList(List<Snake> snake){
        board.setSnake(snake);
    }

    public void setLadderList(List<Ladder> ladder){
        board.setLadder(ladder);

    }

    public void setPlayer(List<Player> players){
        Map<String,Integer> playerIntegerMap = new HashMap<>();
        for(Player player : players){
            this.players.offer(player);
            playerIntegerMap.put(player.getId(),0);
        }
        board.setPlayerPosition(playerIntegerMap);
    }



    private boolean checkObstacle(Integer position){
        for(Snake s : board.getSnake()){
            if(s.getStart() == position) return true;
        }

        for(Ladder l : board.getLadder()){
            if(l.getStart() == position) return true;
        }

        return false;
    }

    private Integer getNewPositionAfterObstacle(Integer position){
        for(Snake s : board.getSnake()){
            if(s.getStart() == position) return s.getEnd();
        }

        for(Ladder l : board.getLadder()){
            if(l.getStart() == position) return l.getEnd();
        }

        return -1;
    }



    private void movePlayer(Player currentPlayer,Integer nextPosition, int dice){
        int previousPosition = nextPosition;
        while(checkObstacle(nextPosition)){
            nextPosition = getNewPositionAfterObstacle(nextPosition);
        }

        if(nextPosition <= board.getBoardSize()){
            board.setPlayerCurrentPosition(currentPlayer.getId(),nextPosition);
        }

        System.out.println(currentPlayer.getName() + " rolled a " + dice + " and move from " + previousPosition + " to " + nextPosition );
    }

    private boolean hasPlayerWon(Player currentPlayer){
        if(board.getPlayerPosition(currentPlayer.getId()) == board.getBoardSize()){
            return true;
        }
        return false;
    }



    public void startGame(){
        while(!isGameComplete){
            int rolledDice = DiceService.roll();
            Player currentPlayer = players.peek();
            Integer nextPosition = board.getPlayerPosition(currentPlayer.getId()) + rolledDice;
            movePlayer(currentPlayer,nextPosition,rolledDice);
            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getName() + " wins the game");
                isGameComplete = true;
            }
            else{
                players.offer(players.poll());
            }

        }
    }




}
