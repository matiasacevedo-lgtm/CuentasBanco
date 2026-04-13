/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controlador;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author HP
 */
public class ControladorBancoTest {

    @Test
    public void testCrearYBuscarCuenta() {
        ControladorBanco controlador = new ControladorBanco();
        controlador.crearCuentaAhorros("10", "Maria", 2, 2, 2025, 500);

        assertNotNull(controlador.buscarCuenta("10"));
    }

    @Test
    public void testCrearYConsignar() {
        ControladorBanco controlador = new ControladorBanco();
        controlador.crearCuentaCorriente("20", "Pedro", 3, 3, 2025, 200, 300);

        assertTrue(controlador.consignar("20", 100));
    }
}
