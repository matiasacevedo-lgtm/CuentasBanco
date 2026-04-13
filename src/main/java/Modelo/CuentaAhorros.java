/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HP
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(String numero, String nombreDueno, Fecha fechaApertura, double saldo) {
        super(numero, nombreDueno, fechaApertura, saldo);
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
        return retirar(valor);
    }

    @Override
    public String toString() {
        return "CuentaAhorros -> " + super.toString();
    }
}