package service;

import java.util.Random;

public class DiceService {
    public static Integer roll(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }
}
