/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HP
 */
public class CuentaCorriente extends Cuenta {

    private double sobregiro;

    public CuentaCorriente(String numero, String nombreDueno, Fecha fechaApertura, double saldo, double sobregiro) {
        super(numero, nombreDueno, fechaApertura, saldo);
        this.sobregiro = sobregiro;
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean retirar(double valor, boolean usarSobregiro) {
        if (valor <= 0) {
            return false;
        }

        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }

        if (usarSobregiro) {
            double disponible = getSaldo() + sobregiro;
            if (disponible >= valor) {
                setSaldo(getSaldo() - valor);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "CuentaCorriente -> " + super.toString() + ", sobregiro=" + sobregiro;
    }
}