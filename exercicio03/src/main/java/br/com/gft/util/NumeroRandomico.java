package br.com.gft.util;

import java.util.Random;

public class NumeroRandomico {
    public int numeroRandom(int faixa){
        return new Random().nextInt(faixa);
    }
}
