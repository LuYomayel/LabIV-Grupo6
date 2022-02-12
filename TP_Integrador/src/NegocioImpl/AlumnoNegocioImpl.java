package NegocioImpl;

import java.util.ArrayList;
import java.util.*;

import Dao.AlumnoDao;
import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;


public class AlumnoNegocioImpl {
	AlumnoDao aDao = new AlumnoDaoImpl();

	public int agregarAlumno(Alumno alumno) {
		int estado = 0;
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
			estado=aDao.agregarAlumno(alumno);
		}
		return estado;
	}

	public ArrayList<Alumno> listarAlumnosnos() {
		ArrayList<Alumno> Lista = null;
		Lista = aDao.ListarAlumnos();
		
		return aDao.ListarAlumnos();
	}


	public int eliminarAlumno(int id) {
		int estado = 0;
//		--String Apellido = aDao.getApellido;		
//		--Alumno alumno = obtenerAlumno(Apellido);
//		if(alumno.getLegajo()>0 )//También se puede preguntar si existe ese ID 
//		{
//			estado=aDao.eliminarAlumno(id);
//		}
		return estado; 
	}
	



	public int Baja(Alumno a) {
		int bajaAl = 0;
		bajaAl = aDao.Baja(a);
		return bajaAl;
	}
}
