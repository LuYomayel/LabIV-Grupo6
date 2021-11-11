package Dominio;

public class Curso {
	private Materia materia;
	private String semestre;
	private int año;
	private Docente docente;
	private Alumno alumno;
	
	public Curso() {
		
	}
	
	
	public Curso(String semestre, int año) {
		super();	
		this.semestre = semestre;
		this.año = año;
		
	}
	
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getIdMateria() {
		return materia.getIdMateria();
	}
	
	public String getNombreMateria() {
		return materia.getNombreMateria();
		
	}
	
	public int getLegajoDocente() {
		return docente.getLegajo();
	}
	
	public String getNombreCompletoDocente() {
		return docente.toString();
		
	}
	
	
	
	
}
