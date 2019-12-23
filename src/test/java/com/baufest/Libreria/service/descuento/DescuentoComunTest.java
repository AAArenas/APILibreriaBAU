package com.baufest.Libreria.service.descuento;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DescuentoComunTest {
    @Test
    public void probarCalculoDescuentoComun(){
        double montoAProbar=100.00;
        DescuentoComun descuentoComun=new DescuentoComun();
        double resultadoFinal= descuentoComun.calcularDescuento(montoAProbar);
        Assertions.assertTrue(95.00==resultadoFinal,"Fallo el metodo al aplicar descuento comun");

    }
}
