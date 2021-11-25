package Dao;

import java.util.ArrayList;

import Entidad.Docente;

public interface DocenteDao {
	public int agregarDocente(Docente docente);
	public ArrayList<Docente> ListarDocentes();
	public int eliminarDocente(int id);
	public Docente obtenerDocente(String apellido);
	
}
