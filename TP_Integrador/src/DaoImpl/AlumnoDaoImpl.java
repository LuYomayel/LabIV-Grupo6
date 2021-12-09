package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.AlumnoDao;
import Entidad.Alumno;

public class AlumnoDaoImpl implements AlumnoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "admin"; // "root"
	private static String dbName = "dbunt2";
	
	
	@Override
	public int agregarAlumno(Alumno alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="INSERT INTO alumnos(legajo, dni,nombre,apellido,fechaNac,direccion,nacionalidad,provincia,email,telefono)VALUES("+alumno.getLegajo()+",'"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getFechanacimiento()+"','"+alumno.getDireccion()+"','"+alumno.getNacionalidad()+"','"+alumno.getProvincia()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
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
	
	
	@Override
	public ArrayList<Alumno> ListarAlumnos() {
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
			String query = "SELECT a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, a.fechaNac FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono  FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad;"; 
					Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Alumno x = new Alumno();
				x.setLegajo(rs.getInt("legajo"));
				x.setDni(rs.getString("dni"));
				x.setNombre(rs.getString("nombre"));
				x.setApellido(rs.getString("apellido"));
				x.setFechanacimiento(rs.getString("fechaNacimiento"));
				x.setDireccion(rs.getString("direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("provincia"));
				x.setLocalidad(rs.getString("Localidad"));
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
	
	
	@Override
	public int eliminarAlumno(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "DELETE FROM alumnos WHERE legajo="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	
	@Override
	public Alumno obtenerAlumno(String apellido) {
		Alumno x = new Alumno();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM alumnos WHERE apellido="+apellido;
			ResultSet rs = st.executeQuery(query);
			rs.next();
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	
	
}
