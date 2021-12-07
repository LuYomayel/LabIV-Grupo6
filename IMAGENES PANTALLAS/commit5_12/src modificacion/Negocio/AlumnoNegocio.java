package Negocio;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoNegocio {
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int legajo);
	public Alumno obtenerAlumno(int legajo);
}
