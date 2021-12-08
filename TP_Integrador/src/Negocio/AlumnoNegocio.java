package Negocio;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoNegocio {
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int id);
	public Alumno obtenerAlumno(String Apellido);
}
