package com.empresalacteos.consulta_factura.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresalacteos.consulta_factura.adapter.AdaptadorUsuario;
import com.empresalacteos.consulta_factura.composite.Pedido;
import com.empresalacteos.consulta_factura.composite.ProductoCompuesto;
import com.empresalacteos.consulta_factura.composite.ProductoPeso;
import com.empresalacteos.consulta_factura.composite.ProductoUnitario;
import com.empresalacteos.consulta_factura.decorator.YogurtBasico;
import com.empresalacteos.consulta_factura.decorator.HomogenizadoYogurtDecorator;
import com.empresalacteos.consulta_factura.decorator.AditivoYogurtDecorator;
import com.empresalacteos.consulta_factura.decorator.Yogurt;
import com.empresalacteos.consulta_factura.facade.Entrega;
import com.empresalacteos.consulta_factura.facade.EntregaFacade;
import com.empresalacteos.consulta_factura.model.Perfil;
import com.empresalacteos.consulta_factura.model.Usuario;
import com.empresalacteos.consulta_factura.prototype.Producto;
import com.empresalacteos.consulta_factura.prototype.Mantequilla;
import com.empresalacteos.consulta_factura.prototype.Leche;
import com.empresalacteos.consulta_factura.singleton.ConfiguradorSingleton;

@RestController
@RequestMapping("/patrones-estructurales")
public class PatronEstructuralController {

	// 1. Adapter
	@GetMapping("/adapter")
	public void adapter() {
		Usuario usuario = new Usuario(); //instancia un objeto de la clase usuario
		usuario.activar();
		System.out.println("Estado Usuario : " + usuario.estaActivo());

		Perfil perfil = new Perfil();
		perfil.activar();
		System.out.println("Estado Perfil : " + perfil.estaActivo());

		AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(); // instancia un objeto de la clase principal del patron adapter
		adaptadorUsuario.activar();
		System.out.println("Estado usuario suspendido : " + adaptadorUsuario.estaActivado());
	}

	// 2. facade
	@GetMapping("/facade")
	public void facade() {
		EntregaFacade facade = new EntregaFacade(); // instancia un objeto de la clase entrega facade
		Entrega entrega = facade.entregaExitosa();

		System.out.println("---------------");

		facade.entregaIncompleto(entrega);
	}

	// 3. decorator
	@GetMapping("/decorator")
	public void clientDecoratorPattern() {
		Yogurt basicYogurt = new YogurtBasico();
		basicYogurt.crearFuncionalidad();
		System.out.println("\n---------");

		Yogurt AditivoYogurt = new AditivoYogurtDecorator(new YogurtBasico());
		AditivoYogurt.crearFuncionalidad();
		System.out.println("\n---------");

		Yogurt HomogenizadoYogurt = new HomogenizadoYogurtDecorator(new AditivoYogurtDecorator(new YogurtBasico()));
		HomogenizadoYogurt.crearFuncionalidad();
	}

	// 4. composite
	@GetMapping("/composite")
	public void composite() {
		// creamos un nuevo pedido
		Pedido pedido = new Pedido("Bodega - San Benito ");

		// Producto que se vende a peso y a un precio por kilogramo
		ProductoPeso queso = new ProductoPeso(5.2, 10.4, "Queso Iberico", "Lacteos");

		//peso - precio por peso
		ProductoPeso mantequilla = new ProductoPeso(0.8, 5.0, "Mantequilla Iberico", "Lacteos");
		// Producto que se vende a un precio por unidad y por un numero de unidades determinadas
		ProductoUnitario paqueteDeLeche = new ProductoUnitario(3, 8.50, "Paquete de Leche", "Lacteos"); //cantidad - precio
		ProductoUnitario paqueteDeLecheCondensado = new ProductoUnitario(6, 12.25, "Paquete de Leche condensado",
				"Lacteos");

		// producto compuesto de varios productos
		ProductoCompuesto cestaDeOferta = new ProductoCompuesto();
		// añadimos los productos individuales al producto compuesto
		cestaDeOferta.addProducto(paqueteDeLecheCondensado);
		cestaDeOferta.addProducto(mantequilla);
		// añadimos los productos al pedido
		pedido.addProducto(queso);
		pedido.addProducto(paqueteDeLeche);
		// mostramos el inporte
		System.out.println("El importe total es: " + pedido.getImporteTotal());
		pedido.addProducto(cestaDeOferta);
		System.out.println("El importe total es: " + pedido.getImporteTotal());

	}

	// 5. singleton
	@GetMapping("/singleton")
	public ConfiguradorSingleton metodoSingleton() {
		ConfiguradorSingleton configurador = ConfiguradorSingleton.getConfigurador("20451256230",
				"Empresa Lácteos EIRL.", "Av. Los Pinos S/N");
		System.out.println(configurador.getNumeroRuc());
		System.out.println(configurador.getNombreRazonSocial());
		System.out.println(configurador.getDireccion());
		return configurador;
	}

	// 6. prototype
	@GetMapping("/prototype")
	public void metodoPrototype() {
		List<Producto> productos = new ArrayList<>();
	    Mantequilla mantequilla = new Mantequilla();
	    mantequilla.cantidad = 4;
	    mantequilla.bolsiTarro = true;
	    mantequilla.botella = true;
	    mantequilla.sabor = "fresa";
	    mantequilla.flexibilidad = true;
	    productos.add(mantequilla);
	    Mantequilla mantequilla2 = (Mantequilla) mantequilla.clone();
	    productos.add(mantequilla2);
	    Leche leche = new Leche();
	    leche.frase = "Leche descremada con 80% de proteinas";
	    leche.sabor = "vainilla";
	    leche.cantidad = 2;
	    leche.bolsiTarro = false;
	    leche.botella = true;
	    productos.add(leche);
	    Leche anotherParrot = (Leche) leche.clone();
	    productos.add(anotherParrot);
	    System.out.println("Mantequilla igual " + productos.get(0).equals(productos.get(1)));
	    System.out.println("Leche igual " +productos.get(2).equals(productos.get(3)));
	  
	}

}
