package br.com.gft;

import br.com.gft.model.Guerreiro;
import br.com.gft.model.Mago;
import br.com.gft.model.Personagem;

public class Main {
    public static void main(String[] args) {
        Mago m1 = new Mago();
        m1.setNome("Merlin");
        Mago m2 = new Mago();
        Mago m3 = new Mago();
        Mago m4 = new Mago();

        m1.lvlUp();
        m1.mostrarStatus();
        System.out.println(m1.getNome() + " ao atacar causa um dano de: " + m1.attack());

        Guerreiro g1 = new Guerreiro();
        g1.setNome("Tigas Esparta");
        Guerreiro g2 = new Guerreiro();
        Guerreiro g3 = new Guerreiro();
        Guerreiro g4 = new Guerreiro();

        g1.lvlUp();
        g1.mostrarStatus();
        System.out.println(g1.getNome() + " ao atacar causa um dano de: " + g1.attack());
        System.out.println("Quantidade de personagens criados: " + Personagem.getQuantidadePersonagensCriados());
    }
}
