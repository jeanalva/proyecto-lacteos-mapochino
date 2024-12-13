package com.empresalacteos.consulta_factura.prototype;

import java.util.Objects;

public abstract class Producto {
  public int cantidad;
  public boolean bolsiTarro;
  public boolean botella;
  public String sabor;

  public Producto() {
  }

  public Producto(Producto target) {
    if (target != null) {
      this.cantidad = target.cantidad;
      this.bolsiTarro = target.bolsiTarro;
      this.botella = target.botella;
      this.sabor = target.sabor;

    }
  }

  public abstract Producto clone();

  @Override
  public boolean equals(Object object2) {
    if (!(object2 instanceof Producto)) return false;
    Producto producto2 = (Producto) object2;
    return producto2.bolsiTarro = bolsiTarro && producto2.cantidad == cantidad
        && producto2.botella == botella && Objects.equals(producto2.sabor, sabor);
  }
}



