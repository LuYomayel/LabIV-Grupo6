package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.DocenteDaoImpl;
import DaoImpl.LocalidadDaoImpl;
import DaoImpl.PaisDaoImpl;
import DaoImpl.ProvinciaDaoImpl;
import Entidad.Alumno;
import Entidad.Docente;
import Entidad.Localidad;
import Entidad.Pais;
import Entidad.Provincia;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Agregar Alumno
		/*
		PaisDaoImpl pDao = new PaisDaoImpl();
		ArrayList<Pais> listaPais = pDao.ListarPais();
		ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
		ArrayList<Provincia> listaProv = provDao.ListarProvincia();
		LocalidadDaoImpl lDao = new LocalidadDaoImpl();
		ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();*/

		if(request.getParameter("btnAgregar") !=null){
			//System.out.println(request.getParameter("Legajo"));
			if(request.getParameter("txtDni")!=null && request.getParameter("txtNombre")!=null && request.getParameter("txtApellido")!=null && request.getParameter("txtFecha")!=null&& request.getParameter("txtDireccion")!=null && request.getParameter("Nacionalidad")!=null && request.getParameter("Provincia")!=null && request.getParameter("Localidad")!=null && request.getParameter("txtEmail")!=null&& request.getParameter("txtTelefono")!=null) {
				int filas =0;
				Alumno alu = new Alumno();
				
				alu.setLegajo(Integer.parseInt(request.getParameter("Legajo")));
				alu.setDni(request.getParameter("txtDni"));
				alu.setNombre(request.getParameter("txtNombre"));
				alu.setApellido(request.getParameter("txtApellido"));
				alu.setFechanacimiento(request.getParameter("txtFecha"));
				alu.setDireccion(request.getParameter("txtDireccion"));
				alu.setNacionalidad(request.getParameter("Nacionalidad"));
				alu.setProvincia(request.getParameter("Provincia"));
				alu.setLocalidad(request.getParameter("Localidad"));
				alu.setEmail(request.getParameter("txtEmail"));
				alu.setTelefono(request.getParameter("txtTelefono"));
				alu.setIdCarrera(Integer.parseInt(request.getParameter("txtIdCarrera")));
				
				AlumnoDaoImpl dao = new AlumnoDaoImpl();
				filas = dao.ModificarAlumno(alu);	
				//filas = 1;
				PaisDaoImpl pDao = new PaisDaoImpl();
				ArrayList<Pais> listaPais = pDao.ListarPais();
				ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
				ArrayList<Provincia> listaProv = provDao.ListarProvincia();
				LocalidadDaoImpl lDao = new LocalidadDaoImpl();
				ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();

				request.setAttribute("ListarProvincia", listaProv);
				request.setAttribute("ListarPais", listaPais);
				request.setAttribute("ListarLocalidad", listaLocal);
				request.setAttribute("cantFilas", filas);
				
				int legajo = Integer.parseInt(request.getParameter("Legajo"));
				legajo++;
				request.setAttribute("legajo", legajo);
				
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnos.jsp");
				rd.forward(request, response);
				
			}

		}
			if(request.getParameter("btnModificar") !=null){
				System.out.println(request.getParameter("idAlumno"));
				
				if(request.getParameter("dniAlumno")!=null && request.getParameter("NombreAlumno")!=null && request.getParameter("ApellidoAlumno")!=null && request.getParameter("NacAlumno")!=null&& request.getParameter("DireccionAlumno")!=null && request.getParameter("PaisAlumno")!=null && request.getParameter("ProvinciaAlumno")!=null && request.getParameter("LocalidadAlumno")!=null && request.getParameter("EmailAlumno")!=null&& request.getParameter("TelefonoAlumno")!=null) {
					int filas =0;
					Alumno alu = new Alumno();
					
					alu.setLegajo(Integer.parseInt(request.getParameter("idAlumno")));
					alu.setDni(request.getParameter("dniAlumno"));
					alu.setNombre(request.getParameter("NombreAlumno"));
					alu.setApellido(request.getParameter("ApellidoAlumno"));
					alu.setFechanacimiento(request.getParameter("NacAlumno"));
					alu.setDireccion(request.getParameter("DireccionAlumno"));
					alu.setNacionalidad(request.getParameter("PaisAlumno"));
					alu.setProvincia(request.getParameter("ProvinciaAlumno"));
					alu.setLocalidad(request.getParameter("LocalidadAlumno"));
					alu.setEmail(request.getParameter("EmailAlumno"));
					alu.setTelefono(request.getParameter("TelefonoAlumno"));
					alu.setIdCarrera(Integer.parseInt(request.getParameter("CarreraAlumno")));
					
					AlumnoDaoImpl dao = new AlumnoDaoImpl();
					filas = dao.agregarAlumno(alu);	
					//filas = 1;
					PaisDaoImpl pDao = new PaisDaoImpl();
					ArrayList<Pais> listaPais = pDao.ListarPais();
					ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
					ArrayList<Provincia> listaProv = provDao.ListarProvincia();
					LocalidadDaoImpl lDao = new LocalidadDaoImpl();
					ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();

					request.setAttribute("ListarProvincia", listaProv);
					request.setAttribute("ListarPais", listaPais);
					request.setAttribute("ListarLocalidad", listaLocal);
					request.setAttribute("cantFilas", filas);
					
					
					RequestDispatcher rd = request.getRequestDispatcher("/ModificarAlumno.jsp");
					rd.forward(request, response);
					
				}
				else {
					
					int legajo = 1000;
					AlumnoDaoImpl dao = new AlumnoDaoImpl();
					ArrayList<Alumno> lista= dao.ListarAlumnos();
					request.setAttribute("listaA", lista);
					
					if(lista != null) {
						for(Alumno alumno : lista) {
							if(alumno.getLegajo()>legajo) legajo = alumno.getLegajo();
							
						}
						
					}
					legajo++;
					
					PaisDaoImpl pDao = new PaisDaoImpl();
					ArrayList<Pais> listaPais = pDao.ListarPais();
					ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
					ArrayList<Provincia> listaProv = provDao.ListarProvincia();
					LocalidadDaoImpl lDao = new LocalidadDaoImpl();
					ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
					request.setAttribute("ListarProvincia", listaProv);
					request.setAttribute("ListarPais", listaPais);
					request.setAttribute("ListarLocalidad", listaLocal);
					RequestDispatcher rd= request.getRequestDispatcher("/ModificarAlumno.jsp");
					rd.forward(request, response);
				}
				
			}
		if(request.getParameter("Param")!= null) {
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			
			request.setAttribute("listaA", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("ListarTodos")!= null) {
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			
			request.setAttribute("listaA", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("ParamPais")!=null) {
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> lista = pDao.ListarPais();
			
			request.setAttribute("ListarPais", lista);
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			
			request.setAttribute("ListarProvincia", listaProv);
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarLocalidad", listaLocal);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminar")!=null)
		{
			String aux = request.getParameter("idAlumno").toString();
			
			int id = Integer.parseInt(request.getParameter("idAlumno").toString()) ;
			AlumnoDaoImpl udao = new AlumnoDaoImpl();
			//udao.eliminarAlumno(id);
			
            ArrayList<Alumno> lista= udao.ListarAlumnos();
			request.setAttribute("listaA", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("Agregar")!=null) {
			int legajo = 1000;
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listaA", lista);
			
			if(lista != null) {
				for(Alumno alumno : lista) {
					if(alumno.getLegajo()>legajo) legajo = alumno.getLegajo();
					System.out.println(legajo);
				}
				
			}
			legajo++;
			
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			
			request.setAttribute("legajo", legajo);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumnos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Modificar")!=null) {
			int legajo = 1000;
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listaA", lista);
			
			if(lista != null) {
				for(Alumno alumno : lista) {
					if(alumno.getLegajo()>legajo) legajo = alumno.getLegajo();
					System.out.println(legajo);
				}
				
			}
			legajo++;
			
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			
			request.setAttribute("legajo", legajo);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarAlumno.jsp");
			rd.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	if(request.getParameter("btnMostrarAlumnos")!=null) 
		{
			AlumnoDaoImpl dao = new AlumnoDaoImpl();
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listaA", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");
			rd.forward(request, response);
		}
		*/
		if(request.getParameter("btnEliminar")!=null) {
			int id= Integer.parseInt(request.getParameter("legajo").toString());
			AlumnoDaoImpl dao =new AlumnoDaoImpl();
			dao.eliminarAlumno(id);
			
			ArrayList<Alumno> lista= dao.ListarAlumnos();
			request.setAttribute("listaA", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoAlumnos.jsp");
			rd.forward(request, response);
			
		}
	}

}
