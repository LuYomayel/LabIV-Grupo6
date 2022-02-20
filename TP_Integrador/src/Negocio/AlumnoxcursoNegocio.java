package Negocio;

import java.util.ArrayList;

import Entidad.Alumnoxcurso;

public interface AlumnoNegocio {
	public int agregarAlumnoxcurso(Alumnoxcurso alumnoxcurso);
	public ArrayList<Alumnoxcurso> ListarAlumnosxcurso();
	public int eliminarAlumnoxcurso(int id);
	//public Alumnoxcurso obtenerAlumnoxcurso(String Apellido);
	public int Baja(Alumnoxcurso axc);
}
