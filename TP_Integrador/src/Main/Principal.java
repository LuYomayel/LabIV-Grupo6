package main;

import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocio.DocenteNegocio;
import negocioImpl.DocenteNegocioImpl;
import negocio.PaisNegocio;
import negocioImpl.PaisNegocioImpl;
import negocio.ProvinciaNegocio;
import negocioImpl.ProvinciaNegocioImpl;
import negocio.LocalidadNegocio;
import negocioImpl.LocalidadNegocioImpl;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

import Servlets.ServletLogin;

public class Principal {
	
	public static void main(String[] args) {
		
		VentanaPrincipal vista = new VentanaPrincipal();
		
		AlumnoNegocio negocio = new AlumnoNegocioImpl();
		DocenteNegocio negocio = new DocenteNegocioImpl();
		PaisNegocio negocio = new PaisNegocioImpl();
		ProvinciaNegocio negocio = new ProvinciaNegocioImpl();
		LocalidadNegocio negocio = new LocalidadNegocioImpl();
		UsuarioNegocio negocio = new UsuarioNegocioImpl();
		
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
	}

}
