package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import negocio.AlumnoNegocio;
import negocio.DocenteNegocio;
import negocio.PaisNegocio;
import negocio.ProvinciaNegocio;
import negocio.LocalidadNegocio;
import negocio.UsuarioNegocio;
import presentacion.vista.VentanaPrincipal;
import entidad.Alumno;
import entidad.Docente;
import entidad.Pais;
import entidad.Provincia;
import entidad.Localidad;

public class Controlador implements ActionListener
{
		private VentanaPrincipal ventanaPrincipal;
		private AlumnoNegocio aNeg;
		private DocenteNegocio dNeg;
		private PaisNegocio paNeg;
		private ProvinciaNegocio prNeg;
		private LocalidadNegocio lNeg;
		private UsuarioNegocio uNeg;
		private ArrayList<Persona> personasEnTabla;
		
		public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
		{
			this.ventanaPrincipal = vista;
			this.pNeg = pNeg;
			this.ventanaPrincipal.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.ventanaPrincipal.getBtnBorrar().addActionListener(s->borrarPersona(s));
		}
		
		
	
		
}
