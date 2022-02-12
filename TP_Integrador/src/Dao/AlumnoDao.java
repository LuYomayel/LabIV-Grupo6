package Dao;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoDao {
	String getApellido = null;
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int id);
	public Alumno obtenerAlumno(String apellido);
	public int ModificarAlumno(Alumno alumno);
	public Alumno obtenerAlumnoxID(int id);
	public Alumno obtenerAlumnoxApellido(String apellido);
	public int Baja(Alumno a);

	
}
