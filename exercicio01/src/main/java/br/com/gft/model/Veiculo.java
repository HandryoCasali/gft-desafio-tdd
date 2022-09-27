package br.com.gft.model;

import br.com.gft.excecoes.ChamadoMetodoInvalidoException;

public class Veiculo {

    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private float km;
    private boolean isLigado = false;
    private int litrosCombustivel;
    private int velocidade;
    private int preco;
    private final int LIMITE_COMBUSTIVEL_TANQUE = 60;

    public void ligar() {
        if(isLigado){
            throw new ChamadoMetodoInvalidoException("Veiculo já está ligado!");
        }
        this.isLigado = true;
    }

    public void desligar() {
        if(!isLigado){
           throw new ChamadoMetodoInvalidoException("Veiculo já está desligado!");
        }
        if(this.velocidade > 0){
            throw new ChamadoMetodoInvalidoException("Veiculo com velocidade acima de zero não pode ser desligado!");
        }
        this.isLigado = false;
    }

    public void abastecer(int litrosCombustivel) {
        int quantidadePreencherTanque = this.LIMITE_COMBUSTIVEL_TANQUE - this.litrosCombustivel;
        if(this.isLigado){
            throw new ChamadoMetodoInvalidoException("Não é permitido abastecer com o carro ligado!");
        }
        if(litrosCombustivel > quantidadePreencherTanque){
            throw new ChamadoMetodoInvalidoException("Quantidade de combustivel ultrapassa o limite do tanque!");
        }
        this.litrosCombustivel = litrosCombustivel;
    }

    public void acelerar() {
        if(!this.isLigado){
            throw new ChamadoMetodoInvalidoException("Não é possível acelerar o carro desligado!");
        }
        this.velocidade += 20;
    }

    public void frear() {
        if(this.velocidade == 0 ){
            throw new ChamadoMetodoInvalidoException("Carri ja está parado!");
        }

        this.velocidade -= 20;
    }

    public void pintar(String cor){
        this.cor = cor;
    }

    public boolean getIsLigado(){
        return this.isLigado;
    }

    public void setIsLigado(boolean isLigado){
        this.isLigado = isLigado;
    }

    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }

    public String getCor() {
        return this.cor;
    }

    public int getLitrosCombustivel() {
        return this.litrosCombustivel;
    }

    public void setLitrosCombustivel(int litrosCombustivel) {
        this.litrosCombustivel = litrosCombustivel;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
