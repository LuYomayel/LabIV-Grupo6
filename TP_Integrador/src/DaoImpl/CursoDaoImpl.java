package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.CursoDao;
import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;

public class CursoDaoImpl implements CursoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "admin";  // "root"
	private static String dbName = "dbunt2";
	
	@Override
	public int agregarCurso(Curso curso, Materia materia, Docente docente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String query="INSERT INTO cursos( idMateria, Descripcion_curso, semestre, Año, idDocente)VALUES("+materia.getIdMateria()+",'"+materia.getNombreMateria()+"','"+curso.getSemestre()+"','"+curso.getAño()+"','"+docente.getId()+")";
		Connection cn=null;
		int filas=0;
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			Statement st=cn.createStatement();
			filas=st.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public ArrayList<Curso> ListarCursos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Curso>listaCursos = new ArrayList<Curso>();
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+"dbunt2",user,pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT c.idCurso,m.Descripcion_Materia, c.Descripcion_curso, c.Semestre,\r\n" + 
					" c.Año, d.Nombre, d.Apellido, car.Descripcion_carrera FROM cursos c\r\n" + 
					"LEFT JOIN materias m ON c.idMateria = m.idMateria\r\n" + 
					"LEFT JOIN docentes d ON c.idDocente = d.idDocente\r\n" + 
					"LEFT JOIN carreras car ON d.idCarrera = car.idCarrera; ");
				while(rs.next()) {
					Curso x =new Curso();
					//x.setMateria(rs.); No puedo asignarle del resulset un objeto a X
					//setMateria, setSemestre, setAño, setDocente
				}cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		finally {
		}
		return listaCursos;
	}
	
}
