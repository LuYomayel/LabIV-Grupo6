package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.PaisDao;

import Entidad.Pais;

public class PaisDaoImpl implements PaisDao {
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "admin";/* "root";*/
	private static String dbName = "dbutn2";
	@Override
	public int AgregarPais(Pais pais) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "INSERT INTO paises(idPais,descripcion) values("+pais.getIdPais()+",'"+pais.getDescripcionPais()+"')";
		
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
	public ArrayList<Pais> ListarPais() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Pais> listarPais= new ArrayList<Pais>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "Select idPais, descripcion from paises order by descripcion asc;";
					Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
			Pais x = new Pais();
			x.setIdPais(rs.getInt("idPais"));
			x.setDescripcionPais(rs.getString("Descripcion"));
			listarPais.add(x);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listarPais;
	}
	@Override
	public int eliminarPais(int id) {
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
			String query = "DELETE FROM paises WHERE idpais ="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	@Override
	public Pais obtenerPais(int id) {
		Pais x = new Pais();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM paises WHERE idPais="+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setIdPais(rs.getInt("IdPais"));
			x.setDescripcionPais(rs.getString("Descripcion"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	

}
