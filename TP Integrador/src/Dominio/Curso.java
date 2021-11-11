package Dominio;

public class Curso {
	private Materia materia;
	private String semestre;
	private int a�o;
	private Docente docente;
	private Alumno alumno;
	
	public Curso() {
		
	}
	
	
	public Curso(String semestre, int a�o) {
		super();	
		this.semestre = semestre;
		this.a�o = a�o;
		
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
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
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
