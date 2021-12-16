package Dao;

import java.util.ArrayList;

import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;

public interface CursoDao {
	public int agregarCurso(Curso curso, Materia materia, Docente docente);
	public ArrayList<Curso> ListarCursos();
}
