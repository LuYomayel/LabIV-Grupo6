/*package NegocioImpl;

import java.util.ArrayList;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import Entidad.Docente;
import Negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio{
	DocenteDao ddao = new DocenteDaoImpl();
	
	@Override
	public int agregarDocente(Docente docente) {
		int estado=0;
		if(docente.getLegajo()>0 && 
				docente.getDni().trim().length()>0 &&
				docente.getNombre().trim().length()>0 &&
				docente.getApellido().trim().length()>0 &&
				docente.getFechanacimiento().trim().length()>0 &&
				docente.getDireccion().trim().length()>0 &&
				docente.getLocalidad().trim().length()>0 &&
				docente.getNacionalidad().trim().length()>0 &&
				docente.getEmail().trim().length()>0 &&
				docente.getTelefono().trim().length()>0 && 
				docente.getIdCarrera()>0)
		{
			estado=ddao.agregarDocente(docente);
		}
		return estado;
	}

	@Override
	public ArrayList<Docente> ListarDocentes() {
		return ddao.ListarDocentes();
	}

	@Override
	public int eliminarDocente(int legajo) {
		int estado=0;
		String Apellido = ddao.getApellido;
		Docente docente =obtenerDocente(legajo);
		if(docente.getLegajo()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=ddao.eliminarDocente(legajo);
		}
		return estado;  //estado al ser int pregunto por el 0
	}

	@Override
	public Docente obtenerDocente(int legajo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente obtenerDocente(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

}*/
