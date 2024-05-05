import entities.Ladder;
import entities.Player;
import entities.Snake;
import service.BoardService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        run();
    }

    public static void callBoardService(List<List<Integer>> snakeInput,List<List<Integer>> LadderInput,List<String> Players){
        List<Snake> snakes = new ArrayList<>();
        for(List<Integer> snake : snakeInput){
            Snake s = new Snake(snake.get(0),snake.get(1));
            snakes.add(s);
        }

        List<Ladder> ladders = new ArrayList<>();
        for(List<Integer> ladder : LadderInput){
            Ladder l = new Ladder(ladder.get(0),ladder.get(1));
            ladders.add(l);
        }

        List<Player> players = new ArrayList<>();
        for(String player : Players ){
            Player p = new Player(player);
            players.add(p);
        }

        BoardService boardService = new BoardService();
        boardService.setSnakeList(snakes);
        boardService.setLadderList(ladders);
        boardService.setPlayer(players);
        boardService.startGame();
    }

    public static void run() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("sample_input_output/input.txt"));
        System.setOut(new PrintStream(new File("sample_input_output/output.txt")));
        List<List<Integer>> snakeInput = new ArrayList<>();
        List<List<Integer>> LadderInput = new ArrayList<>();
        List<String> player = new ArrayList<>();
        try(br){
            int numberOfsnake = Integer.parseInt(br.readLine());
            for(int i = 0;i<numberOfsnake;i++){
                 List<Integer> snakePoints = new ArrayList<>();
                 List<String> tokens = Arrays.asList(br.readLine().split(" "));
                 snakePoints.add(Integer.parseInt(tokens.get(0)));
                 snakePoints.add(Integer.parseInt(tokens.get(1)));
                 snakeInput.add(snakePoints);
            }

            int numberOfLadder = Integer.parseInt(br.readLine());
            for(int i = 0;i<numberOfLadder;i++){
                List<Integer> LadderPoints = new ArrayList<>();
                List<String> tokens = Arrays.asList(br.readLine().split(" "));
                LadderPoints.add(Integer.parseInt(tokens.get(0)));
                LadderPoints.add(Integer.parseInt(tokens.get(1)));
                LadderInput.add(LadderPoints);
            }

            int numberOfPlayer = Integer.parseInt(br.readLine());
            for(int i = 0;i<numberOfPlayer;i++){
                player.add(br.readLine());
            }


            callBoardService(snakeInput,LadderInput,player);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}