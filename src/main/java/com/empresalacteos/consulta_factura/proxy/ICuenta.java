package com.empresalacteos.consulta_factura.proxy;

import com.empresalacteos.consulta_factura.model.Cuenta;

public interface ICuenta {
	
	Cuenta retirarDinero(Cuenta cuenta, double monto);
	Cuenta depositarDinero(Cuenta cuenta, double monto);
	void mostrarSaldo(Cuenta cuenta);

}
