/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author HP
 */
public class CuentaTest {

    @Test
    public void testConsignarCuentaAhorros() {
        CuentaAhorros cuenta = new CuentaAhorros("1", "Ana", new Fecha(1, 1, 2025), 100);
        cuenta.consignar(50);
        assertEquals(150, cuenta.getSaldo());
    }

    @Test
    public void testRetiroCuentaCorrienteConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente("2", "Luis", new Fecha(1, 1, 2025), 100, 200);
        assertTrue(cuenta.retirar(250, true));
    }
}
