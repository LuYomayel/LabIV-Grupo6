package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
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
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int eliminarPais(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Pais obtenerPais(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
