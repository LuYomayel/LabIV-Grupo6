package Entidad;


public class Curso {
	private int idCurso;
	private int idMateria;
	private String Descripcion_curso;
	private String semestre;
	private int a�o;
	private int idDocente;
	//private Alumno alumno;  MAL, se asigna un grupo de alumnos. Toloza
	//Para hacer el ArrayList =Descripcion_materia.
	private String Descripcion_materia;
	
	public Curso() {
	}
	/*public Curso(String semestre, int a�o) {
		super();	
		this.semestre = semestre;
		this.a�o = a�o;
	}Toloza*/
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public String getDescripcion_curso() {
		return Descripcion_curso;
	}
	public void setDescripcion_curso(String descripcion_curso) {
		Descripcion_curso = descripcion_curso;
	}
	
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	
	
	//////////////////////////
	public String getDescripcion_materia() {
		return Descripcion_materia;
	}
	public void setDescripcion_materia(String descripcion_materia) {
		Descripcion_materia = descripcion_materia;
	}	
	
}
