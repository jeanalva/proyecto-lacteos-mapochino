package com.empresalacteos.consulta_factura.proxy;

import com.empresalacteos.consulta_factura.model.Cuenta;

public class CuentaProxy implements ICuenta {

	private ICuenta cuentaReal; // esta es la implementacion definida

	public CuentaProxy(ICuenta cuentaReal) {
		this.cuentaReal = cuentaReal;
	}

	// encapsuar la logica, el cliente debe utilizar este intermediario CuentaProxy
	// para llegar al objeto final

	// implementamos los 3 metodos retirar, depositar y mostrar
	@Override
	public Cuenta retirarDinero(Cuenta cuenta, double monto) {
		System.out.println("----Cuenta Proxy - Retirar Dinero----");
		if (cuentaReal == null) {
			cuentaReal = new CuentaBancoAImpl();
			return cuentaReal.retirarDinero(cuenta, monto);
		} else {
			return cuentaReal.retirarDinero(cuenta, monto);
		}
	}

	@Override
	public Cuenta depositarDinero(Cuenta cuenta, double monto) {
		System.out.println("----Cuenta Proxy - Depositar Dinero----");
		if (cuentaReal == null) {
			cuentaReal = new CuentaBancoAImpl();
			return cuentaReal.depositarDinero(cuenta, monto);
		} else {
			return cuentaReal.depositarDinero(cuenta, monto);
		}
	}

	@Override
	public void mostrarSaldo(Cuenta cuenta) {
		System.out.println("----Cuenta Proxy - Mostrar Dinero----");
		if (cuentaReal == null) {
			cuentaReal = new CuentaBancoAImpl();
			cuentaReal.mostrarSaldo(cuenta);
		} else {
			cuentaReal.mostrarSaldo(cuenta);
		}
	}

}
