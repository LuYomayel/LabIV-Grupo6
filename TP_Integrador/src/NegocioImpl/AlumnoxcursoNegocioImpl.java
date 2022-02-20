package NegocioImpl;

import java.util.ArrayList;
import java.util.*;

import Dao.AlumnoxcursoDao;
import DaoImpl.AlumnoxcursoDaoImpl;
import Entidad.Alumnoxcurso;


public class AlumnoxcursoNegocioImpl {
	AlumnoxcursoDao axcDao = new AlumnoxcursoDaoImpl();

	public int agregarAlumno(Alumnoxcurso alumnoxcurso) {
		int estado = 0;
		if(alumnoxcurso.getEstado().trim().length()>0 &&
				alumnoxcurso.getParcial1()>0 && 
				alumnoxcurso.getParcial2()>0 && 
				alumnoxcurso.getRecupera1()>0 && 
				alumnoxcurso.getRecupera2()>0 && 
				alumnoxcurso.getIdCurso()>0 && 
				alumnoxcurso.getIdAlumno()>0 
				)
		{
			estado=axcDao.agregarAlumnoxcurso(alumnoxcurso);
		}
		return estado;
	}

	public ArrayList<alumnoxcurso> ListarAlumnosxcurso() {
		ArrayList<alumnoxcurso> Lista = null;
		Lista = axcDao.ListarAlumnosxcurso();
		
		return axcDao.ListarAlumnosxcurso();
	}


	public int eliminarAlumnoxcurso(int id) {
		int estado = 0;

		return estado; 
	}
	



	public int Baja(Alumnoxcurso axc) {
		int bajaAl = 0;
		bajaAl = axcDao.Baja(axc);
		return bajaAl;
	}
}