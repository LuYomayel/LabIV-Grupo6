package NegocioImpl;

import java.util.ArrayList;

import Dao.LocalidadDao;
import DaoImpl.LocalidadDaoImpl;
import Entidad.Localidad;
import Negocio.LocalidadNegocio;

public class LocalidadNegocioImpl implements LocalidadNegocio{
	LocalidadDao udao = new LocalidadDaoImpl();
	
	@Override
	public int agregarLocalidad(Localidad localidad) {
		int estado=0;
		if(	Localidad.getIdLocalidad()>0 && 
			localidad.getDescripcion.trim().length()>=0 &&
			Localidad.getIdProvincia()>0)
		{
			estado=ldao.agregarLocalidad(localidad);
		}
		return estado;
	}

	@Override
	public ArrayList<Localidad> ListarLocalidad() {
		return ldao.ListarLocalidades();
	}

	@Override
	public int eliminarLocalidades(int id) {
		int estado=0;
		Localidad localidad =obtenerLocalidad(id);
		if(localidad.getIdLocalidad()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=ldao.eliminarLocalidad(id);
		}
		return estado;  //estado al ser int pregunto por el 0
	}
	

}
