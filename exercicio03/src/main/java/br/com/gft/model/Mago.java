package br.com.gft.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mago extends Personagem{
        private List<String> magia = new ArrayList<>();

        public void aprenderMagia(String magia){
                this.magia.add(magia);
        }

        public int attack(){
                return super.getInteligencia() * getLevel() + super.random.numeroRandom(301);
        }

        @Override
        public void lvlUp() {
                super.setLevel(super.getLevel() + 1);
                super.setMana(super.getMana() + 4);
                super.setInteligencia(super.getInteligencia() + 3);
                super.setVida(super.getVida() + 1);
                super.setForca(super.getForca() + 1);
        }

        public List<String> getMagia() {
                return Collections.unmodifiableList(this.magia);
        }
}
