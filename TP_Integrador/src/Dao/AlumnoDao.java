package Dao;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoDao {
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int id);
	public Alumno obtenerAlumno(String apellido);
}
