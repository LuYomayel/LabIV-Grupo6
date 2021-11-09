package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoDao {
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "";
	private static String dbName = "";
	
	
public AlumnoDao(){		
	}
	
public int agregarAlumno(Alumno alumno){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();						
	}
	String query="INSERT INTO alumnos(dni,nombre,apellido,fechanacimiento,direccion,nacionalidad,provincia,email,telefono)VALUES('"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getFechanacimiento()+"','"+alumno.getDireccion()+"','"+alumno.getNacionalidad()+"','"+alumno.getProvincia()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
	Connection cn = null;
	int filas =0;
	try {
		cn = DriverManager.getConnection(host+dbName,user,pass);
		Statement st =cn.createStatement();
		filas = st.executeUpdate(query);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return filas;
	}

public ArrayList<Alumno> ListarAlumnos(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<Alumno>listaAlumnos = new ArrayList<Alumno>();
	Connection cn= null;
	try {
		cn = DriverManager.getConnection(host+dbName,user,pass);
		String query = "SELECT * FROM alumnos";
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			Alumno x = new Alumno();
			x.setLegajo(rs.getInt("legajo"));
			x.setDni(rs.getString("dni"));
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setFechanacimiento(rs.getString("fechanacimiento"));
			x.setDireccion(rs.getString("direccion"));
			x.setNacionalidad(rs.getString("nacionalidad"));
			x.setProvincia(rs.getString("provincia"));
			x.setEmail(rs.getString("email"));
			x.setTelefono(rs.getString("telefono"));			
			listaAlumnos.add(x);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return listaAlumnos;
	}
}
	

