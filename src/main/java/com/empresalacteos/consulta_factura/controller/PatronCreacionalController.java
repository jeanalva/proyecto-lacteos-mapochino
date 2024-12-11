package com.empresalacteos.consulta_factura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresalacteos.consulta_factura.AbstractFactory.fabricas.FabricaDebito;
import com.empresalacteos.consulta_factura.AbstractBuilder.Proveedor;
import com.empresalacteos.consulta_factura.AbstractBuilder.EnteraLecheBuilder;
import com.empresalacteos.consulta_factura.AbstractBuilder.DescremadaLecheBuilder;
import com.empresalacteos.consulta_factura.AbstractBuilder.Leche;
import com.empresalacteos.consulta_factura.AbstractBuilder.LecheBuilder;
import com.empresalacteos.consulta_factura.AbstractFactory.fabricas.FabricaCredito;
import com.empresalacteos.consulta_factura.AbstractFactory.fabricas.FabricaDePagos;
import com.empresalacteos.consulta_factura.AbstractFactory.fabricas.FabricaOnLine;
import com.empresalacteos.consulta_factura.factory.FactoriaFacturas;
import com.empresalacteos.consulta_factura.factory.Factura;
import com.empresalacteos.consulta_factura.model.Usuario;

@RestController
@RequestMapping("/patrones-creacionales")
public class PatronCreacionalController {

	// 1. patron factory
	@GetMapping("/factory")
	public double factory() {
	Factura f = FactoriaFacturas.getFactura("igv");
//		Factura f = FactoriaFacturas.getFactura("");
		f.setId(1);
		f.setImporte(100);
		System.out.println(f.getImporteIgv());
		return f.getImporteIgv();
	}

	// 2. patron abstract-factory
	@GetMapping("/abstract-factory/{option}")
	public void procesarOperacion(@PathVariable("option") int option) {
		FabricaDebito debito = new FabricaDebito();
		FabricaCredito credito = new FabricaCredito();
		FabricaOnLine enLinea = new FabricaOnLine();
		String salida = null;
		try {
			try {
				int opcion = option;
				switch (opcion) {
				case 1:
					FabricaDePagos.crearFabricaDePagos(debito);
					break;
				case 2:
					FabricaDePagos.crearFabricaDePagos(credito);
					break;
				case 3:
					FabricaDePagos.crearFabricaDePagos(enLinea);
					break;
				default:
					System.out.println("No es un valor de consulta valido");
					break;
				}
			} catch (Exception e) {
				System.out.println("No es un parametro de consulta valido");
			}
		} catch (Exception e) {
			System.out.println("Proceso terminado");
		}
	}

	// 3. patron abstract builder
	@GetMapping("/abstract-builder")
	public Leche metodoBuilder() {
		Proveedor proveedor = new Proveedor();
		LecheBuilder entera_lechebuilder = new EnteraLecheBuilder();
		LecheBuilder descremado_lechebuilder = new DescremadaLecheBuilder();

//		proveedor.setLecheBuilder(entera_lechebuilder);
			proveedor.setLecheBuilder(descremado_lechebuilder);
		proveedor.construirLeche();

		Leche leche = proveedor.getLeche();
		System.out.println("Resultado: " + leche);
		return leche;
	}

}
