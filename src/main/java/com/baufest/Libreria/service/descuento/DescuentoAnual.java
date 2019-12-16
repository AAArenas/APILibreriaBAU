package com.baufest.Libreria.service.descuento;

public class DescuentoAnual extends Descuento {

    private double descuento=0.2;

    @Override
    double calcularDescuento(double monto) {
        return monto - (monto * this.descuento);
    }
}
