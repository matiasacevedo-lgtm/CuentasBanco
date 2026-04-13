/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HP
 */
public class Cuenta {

    private String numero;
    private String nombreDueno;
    private Fecha fechaApertura;
    protected double saldo;

    public Cuenta(String numero, String nombreDueno, Fecha fechaApertura, double saldo) {
        this.numero = numero;
        this.nombreDueno = nombreDueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Fecha fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void consignar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean retirar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    // Sobrecarga
    public boolean retirar(double valor, boolean usarSobregiro) {
        return retirar(valor);
    }

    public String consultarSaldo() {
        return "Saldo actual: " + saldo;
    }

    public String mostrarDatos() {
        return toString();
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero='" + numero + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", fechaApertura=" + fechaApertura +
                ", saldo=" + saldo +
                '}';
    }
}