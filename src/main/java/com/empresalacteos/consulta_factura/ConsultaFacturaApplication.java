package com.empresalacteos.consulta_factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

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
import com.empresalacteos.consulta_factura.constantes.Constantes;
import com.empresalacteos.consulta_factura.constantes.Empresa;
import com.empresalacteos.consulta_factura.memento.Caretaker;
import com.empresalacteos.consulta_factura.memento.Originator;
import com.empresalacteos.consulta_factura.model.Cuenta;
import com.empresalacteos.consulta_factura.observer.UnObservado;
import com.empresalacteos.consulta_factura.observer.UnObservador;
import com.empresalacteos.consulta_factura.proxy.CuentaBancoAImpl;
import com.empresalacteos.consulta_factura.proxy.CuentaBancoBImpl2;
import com.empresalacteos.consulta_factura.proxy.CuentaProxy;
import com.empresalacteos.consulta_factura.proxy.ICuenta;
import com.empresalacteos.consulta_factura.singleton.ConfiguradorSingleton;
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
		System.out.println("===========================================================================");
		System.out.println("1. PATRON PROXY");
		System.out.println("===========================================================================");

		Cuenta c = new Cuenta(1, "Empresa de Lacteos", 100);

		// imprimiendo la cuenta en banco A
		ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoAImpl()); // creamos el proxy para acceder a las
																		// operaciones que quiero realizar a los metodos
																		// definidos en la clase implementacion
		cuentaProxy.mostrarSaldo(c);
		c = cuentaProxy.depositarDinero(c, 50);
		c = cuentaProxy.retirarDinero(c, 20);
		cuentaProxy.mostrarSaldo(c);

		// imprimiendo la cuenta en banco B
		ICuenta cuentaProxyB = new CuentaProxy(new CuentaBancoBImpl2());
		cuentaProxyB.mostrarSaldo(c);
		c = cuentaProxyB.depositarDinero(c, 50);
		c = cuentaProxyB.retirarDinero(c, 20);
		cuentaProxyB.mostrarSaldo(c);

		// 2. PATRON STATE
		System.out.println("===========================================================================");
		System.out.println("2. PATRON STATE");
		System.out.println("===========================================================================");

		Usuario user = new Usuario();
		user.setComprando(true);
		user.setEnable(true);

		ActivoState activeState = new ActivoState(user);
		activeState.onActivo();

		ComprandoState buyingState = new ComprandoState(user);
		buyingState.onComprando();

		DesactivadoState disableState = new DesactivadoState(user);
		disableState.onDesactivo();

		BloqueadoState lockState = new BloqueadoState(user);
		lockState.onBloqueado();

		// 3. PATRON BRIDGE
		System.out.println("===========================================================================");
		System.out.println("3. PATRON BRIDGE");
		System.out.println("===========================================================================");

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
		System.out.println("===========================================================================");

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
		System.out.println("===========================================================================");

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

		// 6. Patron Observer
		System.out.println("===========================================================================");
		System.out.println("6. Patron Observer");
		System.out.println("===========================================================================");

		// Instanciar el objeto que será Observado
		UnObservado objObservado = new UnObservado();
		// Instanciar y registrar un Observador
		UnObservador objObservadorPepe = new UnObservador("Pepe");
		objObservado.agregarObservador(objObservadorPepe);
		// Instanciar y registrar otro Observador
		UnObservador objObservadorJuan = new UnObservador("Juan");
		objObservado.agregarObservador(objObservadorJuan);
		// Instanciar y registrar otro Observador
		UnObservador objObservadorMarta = new UnObservador("Marta");
		objObservado.agregarObservador(objObservadorMarta);

		// 7. Antipatron
		//con patrón singleton
		System.out.println("===========================================================================");
		System.out.println("7. Antipatron: aplicando el patrón singleton");
		System.out.println("===========================================================================");

		ConfiguradorSingleton configurador = ConfiguradorSingleton.getConfigurador(
				"20123456780", 							// ruc
				"Empresa de lácteos MAPOCHINO EIRL.", 	//razon social
				"Av. Los Pinos S/N",					//direccion
				"951753852", 							// telefono
				"mapochino.lacteos@outlok.com" 			//correo
				);
		System.out.println(configurador.getNumeroRuc());
		System.out.println(configurador.getNombreRazonSocial());
		System.out.println(configurador.getDireccion());
		System.out.println(configurador.getTelefono());
		System.out.println(configurador.getCorreo());
		
		System.out.println("===========================================================================");
		System.out.println("Sin Patron creando una clase independiente Empresa, creamos un paquete denominado constantes para declarar las constantes");
		System.out.println("===========================================================================");
		// sin patrón: creamos un paquete denominado constantes para declara la respectiva clase para declarar las constantes
		Empresa datosEmpresa = new Empresa();
		datosEmpresa.setNumeroRuc(Constantes.RUC);
		datosEmpresa.setNombreRazonSocial(Constantes.RAZON_SOCIAL);
		datosEmpresa.setDireccion(Constantes.DIRECCION);
		datosEmpresa.setTelefono(Constantes.TELEFONO);
		datosEmpresa.setCorreo(Constantes.CORREO);
		
		//impresion de los resultados
		System.out.println(datosEmpresa.getNumeroRuc());
		System.out.println(datosEmpresa.getNombreRazonSocial());
		System.out.println(datosEmpresa.getDireccion());
		System.out.println(datosEmpresa.getTelefono());
		System.out.println(datosEmpresa.getCorreo());
	}

}
