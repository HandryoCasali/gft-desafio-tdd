package br.com.gft;

import br.com.gft.model.Gerente;
import br.com.gft.model.Supervisor;
import br.com.gft.model.Vendedor;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Maria", 30,6000.0);
        Supervisor supervisor = new Supervisor("Pedro", 28, 4000.0);
        Vendedor vendedor = new Vendedor("João", 20, 2000.0);

        System.out.println(gerente);
        System.out.println(supervisor);
        System.out.println(vendedor);
    }
}