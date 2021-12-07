package Negocio;

import java.util.ArrayList;

import Entidad.Docente;

public interface DocenteNegocio {
	public int agregarDocente(Docente docente);
	public ArrayList<Docente> ListarDocentes();
	public int eliminarDocente(int legajo);
	public Docente obtenerDocente(int legajo);
}
