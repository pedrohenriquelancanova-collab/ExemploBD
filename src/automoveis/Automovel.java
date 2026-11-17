/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automoveis;

/**
 *
 * @author 2025007300
 */
public class Automovel {

    private int id;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;

    public Automovel() {
    }

    public Automovel(String marca, String modelo, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Automovel: " + "ID: " + id + "\n "
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Placa: " + placa + "\n"
                + "Cor: " + cor;
    }

}
