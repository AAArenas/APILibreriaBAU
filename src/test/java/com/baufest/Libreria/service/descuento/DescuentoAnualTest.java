package com.baufest.Libreria.service.descuento;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DescuentoAnualTest {
    @Test
    public void probarCalculoDescuentoComun(){
        double montoAProbar=100.00;
        DescuentoAnual descuentoComun=new DescuentoAnual();
        double resultadoFinal= descuentoComun.calcularDescuento(montoAProbar);
        Assertions.assertTrue(80.00==resultadoFinal,"Fallo el metodo al aplicar descuento anual");
    }
}
