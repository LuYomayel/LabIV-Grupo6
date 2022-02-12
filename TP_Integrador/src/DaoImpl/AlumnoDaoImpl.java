package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.AlumnoDao;
import Entidad.Alumno;

public class AlumnoDaoImpl implements AlumnoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "admin";  // "root"
	private static String dbName = "dbunt2";
	
	
	@Override
	public int agregarAlumno(Alumno alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="INSERT INTO alumnos(legajo, dni,nombre,apellido,fechaNac,direccion,idPais,idProvincia,idLocalidad,email,telefono,idCarrera)VALUES("+alumno.getLegajo()+",'"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"',STR_TO_DATE('"+alumno.getFechanacimiento()+"','%d/%m/%Y'),'"+alumno.getDireccion()+"','"+alumno.getNacionalidad()+"','"+alumno.getProvincia()+"','"+alumno.getLocalidad()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"',"+1+")";
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
			cn = DriverManager.getConnection(host+"dbunt2",user,pass);
			//String query = "SELECT a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, a.fechaNac FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono, a.idcarrera idCarrera  FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad"; 
					Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, a.fechaNac FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono, a.idcarrera idCarrera  FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad");
					//(query);
//					("SELECT a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, a.fechaNac FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono, a.idcarrera idCarrera  FROM alumnos a");//a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad");
			//("SELECT Legajo,Dni, Nombre, Apellido, fechaNac , direccion , idPais, idProvincia, idLocalidad,  Email,  Telefono,  idCarrera  FROM alumnos");
			
			while (rs.next()) {
				Alumno x = new Alumno();
				x.setLegajo(rs.getInt("Legajo"));
				x.setDni(rs.getString("Dni"));
				x.setNombre(rs.getString("Nombre"));
				x.setApellido(rs.getString("Apellido"));
				x.setFechanacimiento(rs.getString("FechaNacimiento"));
				x.setDireccion(rs.getString("Direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("Provincia"));
				x.setLocalidad(rs.getString("Localidad"));
				x.setEmail(rs.getString("Email"));
				x.setTelefono(rs.getString("Telefono"));	
				x.setIdCarrera(rs.getInt("idCarrera"));
				listaAlumnos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
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
			x.setIdCarrera(rs.getInt("idcarrera"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public int ModificarAlumno(Alumno a) {
		//Alumno alumno = new Alumno();
		int estado = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		int filas =0;
		Connection cn = null;
				
		try {
			
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query=
			"(UPDATE alumnos set "
			+"legajo = '"+a.getLegajo()+"',"			
			+"dni ='"+a.getDni()+"',"
			+"nombre"+a.getNombre()+"',"
			+"',apellido ='"+a.getApellido()+"',"
			+"fechaNac= "+ "'STR_TO_DATE( '"+a.getFechanacimiento()+"','%d/%m/%Y')',"
			+"direccion = '" +a.getDireccion()+"',"
			+"idPais = '"+a.getNacionalidad()+"',"
			+"idProvincia = '"+a.getProvincia()+"',"
			+"idLocalidad = '"+a.getLocalidad()+"',"
			+"email = '"+a.getEmail()+"',"
			+"telefono = '"+a.getTelefono()+"',"
			+"idCarrera ='"+a.getIdCarrera()+"' where legajo = "+a.getId();
			
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	
	}
	
	public int Baja(Alumno a) {
		int estado = 0;
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			statement = conexion.prepareCall("update alumnos set"
					+"Estado = 0"
					+"where ID = " +a.getId()
					);
			statement.execute();
			estado = 1;
		}
		catch (SQLException e) {
			estado = 0 ;
		}
		return estado;
	}


	@Override
	public Alumno obtenerAlumnoxID(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Alumno obtenerAlumnoxApellido(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
