package NegocioImpl;

import java.util.ArrayList;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import Entidad.Docente;
import Negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio{
	DocenteDao dDao = new DocenteDaoImpl();
	
	@Override
	public int agregarDocente(Docente docente) {
		boolean estado=false;
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
			estado=dDao.agregarDocente(docente);
		}
		return estado;
	}

	@Override
	public ArrayList<Docente> ListarDocentes() {
		ArrayList<Docente> Lista = null;
		Lista = dDao.ListarDocentes();
		
		return dDao.ListarDocentes();
	}

	@Override
	public int eliminarDocente(int id) {
		int estado =0;
		/*boolean estado=false;
		String Apellido = ddao.getApellido;
		Docente docente =obtenerDocente(apellido);
		if(docente.getLegajo()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=ddao.eliminarDocente(id);
		}*/
		return estado;  
	}

	@Override
	public Docente obtenerDocente(String apellido) {
		boolean estado=false;
		Docente docente = obtenerDocente(Apellido);
		if(docente.getLegajo()>0 )
		{
			estado=dDao.obtenerDocente(Apellido);
		}
		return estado; 
	}

	@Override
	public Docente obtenerIdDocente(String mail) {
		boolean estado=false;
		Docente docente = obtenerIdDocente(mail);
		if(docente.getLegajo()>0 )
		{
			estado=dDao.obtenerIdDocente(mail);
		}
		return estado; 
	}

	public int Baja(Docente d) {
		int bajaDl = 0;
		bajaDl = dDao.Baja(d);
		return bajaDl;
	}
}
