package com.baufest.Libreria.service.descuento;

public class DescuentoComun extends Descuento {

    private double descuento=0.05;

    @Override
    double calcularDescuento(double monto) {
        return monto - (monto * this.descuento);
    }
}
