package com.empresalacteos.consulta_factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empresalacteos.consulta_factura.bridge.Natural;
import com.empresalacteos.consulta_factura.bridge.ElaborarAlimento;
import com.empresalacteos.consulta_factura.bridge.ElaborarYogurt;
import com.empresalacteos.consulta_factura.bridge.Procesado;
import com.empresalacteos.consulta_factura.command.IMenuItem;
import com.empresalacteos.consulta_factura.command.Menu;
import com.empresalacteos.consulta_factura.command.MenuItemAbrir;
import com.empresalacteos.consulta_factura.command.MenuItemImprimir;
import com.empresalacteos.consulta_factura.command.MenuItemSalir;
import com.empresalacteos.consulta_factura.command.Receptor;
import com.empresalacteos.consulta_factura.memento.Caretaker;
import com.empresalacteos.consulta_factura.memento.Originator;
import com.empresalacteos.consulta_factura.model.Cuenta;
import com.empresalacteos.consulta_factura.proxy.CuentaBancoAImpl;
import com.empresalacteos.consulta_factura.proxy.CuentaBancoBImpl2;
import com.empresalacteos.consulta_factura.proxy.CuentaProxy;
import com.empresalacteos.consulta_factura.proxy.ICuenta;
import com.empresalacteos.consulta_factura.state.ActivoState;
import com.empresalacteos.consulta_factura.state.ComprandoState;
import com.empresalacteos.consulta_factura.state.DesactivadoState;
import com.empresalacteos.consulta_factura.state.BloqueadoState;
import com.empresalacteos.consulta_factura.state.Usuario;

@SpringBootApplication
public class ConsultaFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaFacturaApplication.class, args);

		// 1. PATRON PROXY
		System.out.println("1. PATRON PROXY");
		System.out.println("================");

		Cuenta c = new Cuenta(1, "Empresa de Lacteos", 100);

		// impresion de cuenta en un banco A
		ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoAImpl()); // creamos el proxy para acceder a las
																		// operaciones que quiero realizar a los metodos
																		// definidos en la clase implementacion
		cuentaProxy.mostrarSaldo(c);
		c = cuentaProxy.depositarDinero(c, 50);
		c = cuentaProxy.retirarDinero(c, 20);
		cuentaProxy.mostrarSaldo(c);

		// impresion de cuenta en un banco B
		ICuenta cuentaProxyB = new CuentaProxy(new CuentaBancoBImpl2());
		cuentaProxyB.mostrarSaldo(c);
		c = cuentaProxyB.depositarDinero(c, 50);
		c = cuentaProxyB.retirarDinero(c, 20);
		cuentaProxyB.mostrarSaldo(c);

		// 2. PATRON STATE
		System.out.println("===========================================================================");
		System.out.println("2. PATRON STATE");
		System.out.println("================");

		Usuario user = new Usuario();
		user.setBuying(true);
		user.setEnable(true);

		ActivoState activeState = new ActivoState(user);
		activeState.onActive();

		ComprandoState buyingState = new ComprandoState(user);
		buyingState.onBuy();

		DesactivadoState disableState = new DesactivadoState(user);
		disableState.onDisable();

		BloqueadoState lockState = new BloqueadoState(user);
		lockState.onLock();

		// 3. PATRON BRIDGE
		System.out.println("===========================================================================");
		System.out.println("3. PATRON BRIDGE");
		System.out.println("================");

		// Crear un objeto de tipo 'AbstraccionRefinada' indicándole un
		// 'ImplementadorConcreto'
		ElaborarAlimento lasagna = new ElaborarYogurt(new Natural());
		lasagna.obtener();
		// Ahora le indicamos que use otra implementación para obtener la de verduras
		lasagna.setImplementador(new Procesado());
		lasagna.obtener();
		
		
		
		

		// 4. Patron Command
		System.out.println("===========================================================================");
		System.out.println("4. Patron Command");
		System.out.println("================");

		// Crear el objeto Menú (el Invocador)
		Menu objMenu = new Menu();
		// Crear el Receptor
		Receptor objReceptor = new Receptor();
		// Crear las opciones de menú, indicándoles el Receptor
		IMenuItem objOpcionAbrir = new MenuItemAbrir(objReceptor);
		IMenuItem objOpcionImprimir = new MenuItemImprimir(objReceptor);
		IMenuItem objOpcionSalir = new MenuItemSalir(objReceptor);
		// Agregar las opciones al Menú
		objMenu.add(objOpcionAbrir);
		objMenu.add(objOpcionImprimir);
		objMenu.add(objOpcionSalir);
		// Ejecutar cada opción del menú
		objMenu.get(0).ejecutar();
		objMenu.get(1).ejecutar();
		objMenu.get(2).ejecutar();
		
		
		

		// 5. Patron Memento
		System.out.println("===========================================================================");
		System.out.println("5. Patron Memento");
		System.out.println("================");

		// Crear el objeto originador/creador
		Originator creador = new Originator("Pedro", "Gil Mena");
		// Crear el objeto gestor/vigilante del Memento
		Caretaker vigilante = new Caretaker();
		// Crear el Memento y asociarlo al objeto gestor
		vigilante.setMemento(creador.createMemento());
		// Mostrar los datos del objeto
		System.out.println("Nombre completo: [" + creador.getNombre() + " " + creador.getApellidos() + "]");
		// Modificar los datos del objeto
		creador.setNombre("María");
		creador.setApellidos("Mora Miró");
		// Mostrar los datos del objeto
		System.out.println("Nombre completo: [" + creador.getNombre() + " " + creador.getApellidos() + "]");
		// Restaurar los datos del objeto
		creador.setMemento(vigilante.getMemento());
		// Mostrar los datos del objeto
		System.out.println("Nombre completo: [" + creador.getNombre() + " " + creador.getApellidos() + "]");

	}

}
