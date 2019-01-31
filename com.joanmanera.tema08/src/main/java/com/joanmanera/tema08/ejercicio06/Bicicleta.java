package com.joanmanera.tema08.ejercicio06;

public class Bicicleta {
    private int referencia;
    private String marca;
    private String modelo;
    private double peso;
    private double pulgadasRuedas;
    private boolean haveMotor;
    private String fechaFabricacion;
    private double precio;
    private int existencias;

    public Bicicleta(int referencia, String marca, String modelo, double peso, double pulgadasRuedas, boolean haveMotor, String fechaFabricacion, double precio, int existencias){
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.pulgadasRuedas = pulgadasRuedas;
        this.haveMotor = haveMotor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Bicicleta(){
        this.referencia = 0;
        this.marca = "";
        this.modelo = "";
        this.peso = 0;
        this.pulgadasRuedas = 0;
        this.haveMotor = false;
        this.fechaFabricacion = "";
        this.precio = 0;
        this.existencias = 0;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPulgadasRuedas() {
        return pulgadasRuedas;
    }

    public void setPulgadasRuedas(double pulgadasRuedas) {
        this.pulgadasRuedas = pulgadasRuedas;
    }

    public boolean getHaveMotor() {
        return haveMotor;
    }

    public void setHaveMotor(boolean haveMotor) {
        this.haveMotor = haveMotor;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
