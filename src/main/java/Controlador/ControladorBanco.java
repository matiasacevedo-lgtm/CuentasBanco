/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Cuenta;
import Modelo.CuentaAhorros;
import Modelo.CuentaCorriente;
import Modelo.Fecha;

/**
 *
 * @author HP
 */

public class ControladorBanco {

    private Cuenta[] cuentas;
    private int contador;

    public ControladorBanco() {
        cuentas = new Cuenta[50];
        contador = 0;
    }

    public void crearCuentaAhorros(String numero, String nombre, int dia, int mes, int anio, double saldo) {
        if (contador < cuentas.length) {
            cuentas[contador] = new CuentaAhorros(numero, nombre, new Fecha(dia, mes, anio), saldo);
            contador++;
        }
    }

    public void crearCuentaCorriente(String numero, String nombre, int dia, int mes, int anio, double saldo, double sobregiro) {
        if (contador < cuentas.length) {
            cuentas[contador] = new CuentaCorriente(numero, nombre, new Fecha(dia, mes, anio), saldo, sobregiro);
            contador++;
        }
    }

    public Cuenta buscarCuenta(String numero) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getNumero().equalsIgnoreCase(numero)) {
                return cuentas[i];
            }
        }
        return null;
    }

    public boolean consignar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            cuenta.consignar(valor);
            return true;
        }
        return false;
    }

    public boolean retirar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            return cuenta.retirar(valor);
        }
        return false;
    }

    public boolean retirarConSobregiro(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta != null && cuenta instanceof CuentaCorriente) {
            CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
            return cuentaCorriente.retirar(valor, true);
        }

        return false;
    }

    public String consultarSaldo(String numero) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            return cuenta.consultarSaldo();
        }
        return "Cuenta no encontrada";
    }

    public String mostrarCuenta(String numero) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            return cuenta.mostrarDatos();
        }
        return "Cuenta no encontrada";
    }
}
