package br.com.gft.model;

import br.com.gft.util.NumeroRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Guerreiro extends Personagem{
    private final List<String> habilidade = new ArrayList<>();

    @Override
    public void lvlUp() {
        super.setLevel(super.getLevel() + 1);
        super.setMana(super.getMana() + 1);
        super.setInteligencia(super.getInteligencia() + 1);
        super.setVida(super.getVida() + 4);
        super.setForca(super.getForca() + 3);
    }

    public int attack() {
        return super.getForca() * getLevel() + NumeroRandom.numeroRandom(301);
    }

    public void aprenderHabilidade(String habilidade){
        this.habilidade.add(habilidade);
    }

    public List<String> getHabilidade() {
        return Collections.unmodifiableList(this.habilidade);
    }
}
