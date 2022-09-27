package br.com.gft.excecoes;

public class ChamadoMetodoInvalidoException extends RuntimeException {
    public ChamadoMetodoInvalidoException(String message) {
        super(message);
    }
}
