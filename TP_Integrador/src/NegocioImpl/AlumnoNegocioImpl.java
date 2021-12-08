package NegocioImpl;

import java.util.ArrayList;

import Dao.AlumnoDao;
import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;
import Negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio{
	AlumnoDao adao = new AlumnoDaoImpl();

	@Override
	public int agregarAlumno(Alumno alumno) {
		int estado=0;
		if(alumno.getLegajo()>0 && 
				alumno.getDni().trim().length()>0 &&
				alumno.getNombre().trim().length()>0 &&
				alumno.getApellido().trim().length()>0 &&
				alumno.getFechanacimiento().trim().length()>0 &&
				alumno.getDireccion().trim().length()>0 &&
				alumno.getNacionalidad().trim().length()>0 &&
				alumno.getProvincia().trim().length()>0 &&
				alumno.getEmail().trim().length()>0 &&
				alumno.getTelefono().trim().length()>0 && 
				alumno.getIdCarrera()>0 
				)
		{
			estado=adao.agregarAlumno(alumno);
		}
		return estado;
	}

	@Override
	public ArrayList<Alumno> ListarAlumnos() {
		return adao.ListarAlumnos();
	}

	@Override
	public int eliminarAlumno(int id) {
		int estado=0;
		String Apellido = adao.getApellido;		
		Alumno alumno = obtenerAlumno(Apellido);
		if(alumno.getLegajo()>0 )//También se puede preguntar si existe ese ID 
			//El tema es que el ID lo maneja la base de datos.
		{
			estado=adao.eliminarAlumno(legajo);
		}
		return estado;  //estado al ser int pregunto por el 0
	}

	@Override
	public Alumno obtenerAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
