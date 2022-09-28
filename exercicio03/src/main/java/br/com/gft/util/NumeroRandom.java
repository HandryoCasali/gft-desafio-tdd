package br.com.gft.util;

import java.util.Random;

public class NumeroRandom {
    private static final Random random = new Random();
    public static int numeroRandom(int faixa){
        return random.nextInt(faixa);
    }
}
