package com.empresalacteos.consulta_factura.proxy;

import com.empresalacteos.consulta_factura.model.Cuenta;

public class CuentaBancoAImpl implements ICuenta {

	@Override
	public Cuenta retirarDinero(Cuenta cuenta, double monto) {
		double saldoActual = cuenta.getSaldoInicial() - monto;
		cuenta.setSaldoInicial(saldoActual);
		System.out.println("Saldo actual:" + cuenta.getSaldoInicial());
		return cuenta;
	}

	@Override
	public Cuenta depositarDinero(Cuenta cuenta, double monto) {
		double saldoActual=cuenta.getSaldoInicial()+monto;
		cuenta.setSaldoInicial(saldoActual);
		System.out.println("Saldo actual:" + cuenta.getSaldoInicial());
		return cuenta;
	}

	@Override
	public void mostrarSaldo(Cuenta cuenta) {
		System.out.println("Saldo actual:" + cuenta.getSaldoInicial());
	}

}