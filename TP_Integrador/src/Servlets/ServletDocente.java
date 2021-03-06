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
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!= null) {
			DocenteDaoImpl dao = new DocenteDaoImpl();
			ArrayList<Docente> lista= dao.ListarDocentes();
			request.setAttribute("listaD", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminar")!=null)
		{
			String aux = request.getParameter("idDocente").toString();
			
			int id = Integer.parseInt(request.getParameter("idDocente").toString()) ;
			DocenteDaoImpl udao = new DocenteDaoImpl();
			udao.eliminarDocente(id);
			
            ArrayList<Docente> lista= udao.ListarDocentes();
			request.setAttribute("listaD", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("Agregar")!=null) {
			int legajo = 1000;
			DocenteDaoImpl dao = new DocenteDaoImpl();
			ArrayList<Docente> lista= dao.ListarDocentes();
			request.setAttribute("listaA", lista);
			
			if(lista != null) {
				for(Docente docente : lista) {
					if(docente.getLegajo()>legajo) legajo = docente.getLegajo();
					
				}
				
			}
			legajo++;
			
			request.setAttribute("legajo", legajo);
			
			PaisDaoImpl pDao = new PaisDaoImpl();
			ArrayList<Pais> listaPais = pDao.ListarPais();
			ProvinciaDaoImpl provDao = new ProvinciaDaoImpl();
			ArrayList<Provincia> listaProv = provDao.ListarProvincia();
			LocalidadDaoImpl lDao = new LocalidadDaoImpl();
			ArrayList<Localidad> listaLocal = lDao.ListarLocalidad();
			request.setAttribute("ListarProvincia", listaProv);
			request.setAttribute("ListarPais", listaPais);
			request.setAttribute("ListarLocalidad", listaLocal);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarProfesores.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnModificar") !=null){
			System.out.println(request.getParameter("idDocente"));
			
			if(request.getParameter("dniDocente")!=null && request.getParameter("NombreDocente")!=null && request.getParameter("ApellidoDocente")!=null && request.getParameter("NacDocente")!=null&& request.getParameter("DireccionDocente")!=null && request.getParameter("PaisDocente")!=null && request.getParameter("ProvinciaDocente")!=null && request.getParameter("LocalidadDocente")!=null && request.getParameter("EmailDocente")!=null && request.getParameter("Contrase?aDocente")!=null && request.getParameter("TelefonoDocente")!=null) {
				int filas =0;
				Docente doc = new Docente();
				
				doc.setLegajo(Integer.parseInt(request.getParameter("idDocente")));
				doc.setDni(request.getParameter("dniDocente"));
				doc.setNombre(request.getParameter("NombreDocente"));
				doc.setApellido(request.getParameter("ApellidoDocente"));
				doc.setFechanacimiento(request.getParameter("NacDocente"));
				doc.setDireccion(request.getParameter("DireccionDocente"));
				doc.setNacionalidad(request.getParameter("PaisDocente"));
				doc.setProvincia(request.getParameter("ProvinciaDocente"));
				doc.setLocalidad(request.getParameter("LocalidadDocente"));
				doc.setEmail(request.getParameter("EmailDocente"));
				doc.setEmail(request.getParameter("Contrase?aDocente"));
				doc.setTelefono(request.getParameter("TelefonoDocente"));
				doc.setIdCarrera(Integer.parseInt(request.getParameter("CarreraDocente")));
				
				DocenteDaoImpl dao = new DocenteDaoImpl();
				filas = dao.agregarDocente(doc);	
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
				
				RequestDispatcher rd = request.getRequestDispatcher("/ModificarDocente.jsp");
				rd.forward(request, response);
			}
			else {
				int legajo = 1000;
				DocenteDaoImpl dao = new DocenteDaoImpl();
				ArrayList<Docente> lista= dao.ListarDocentes();
				request.setAttribute("listaA", lista);
				
				if(lista != null) {
					for(Docente docente : lista) {
						if(docente.getLegajo()>legajo) legajo = docente.getLegajo();
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
				RequestDispatcher rd= request.getRequestDispatcher("/ModificarDocente.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregar") !=null){
			
			if(request.getParameter("txtDni")!=null && request.getParameter("txtNombre")!=null && request.getParameter("txtApellido")!=null && request.getParameter("txtFecha")!=null&& request.getParameter("txtDireccion")!=null && request.getParameter("Nacionalidad")!=null && request.getParameter("Provincia")!=null && request.getParameter("Localidad")!=null && request.getParameter("txtEmail")!=null&& request.getParameter("txtTelefono")!=null) {
				int filas =0;
				Docente docente = new Docente();
				
				docente.setLegajo(Integer.parseInt(request.getParameter("Legajo")));
				docente.setDni(request.getParameter("txtDni"));
				docente.setNombre(request.getParameter("txtNombre"));
				docente.setApellido(request.getParameter("txtApellido"));
				docente.setFechanacimiento(request.getParameter("txtFecha"));
				docente.setDireccion(request.getParameter("txtDireccion"));
				docente.setNacionalidad(request.getParameter("Nacionalidad"));
				docente.setProvincia(request.getParameter("Provincia"));
				docente.setLocalidad(request.getParameter("Localidad"));
				docente.setEmail(request.getParameter("txtEmail"));
				docente.setContrase?a(request.getParameter("txtContrase?a"));
				docente.setTelefono(request.getParameter("txtTelefono"));
				
				DocenteDaoImpl dao = new DocenteDaoImpl();
				filas = dao.agregarDocente(docente);	
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
				
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarProfesores.jsp");
				rd.forward(request, response);
				
			}
			else {
				
				int legajo = 1000;
				DocenteDaoImpl dao = new DocenteDaoImpl();
				ArrayList<Docente> lista= dao.ListarDocentes();
				request.setAttribute("listaA", lista);
				
				if(lista != null) {
					for(Docente docente : lista) {
						if(docente.getLegajo()>legajo) legajo = docente.getLegajo();
						
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
				RequestDispatcher rd= request.getRequestDispatcher("/AgregarProfesores.jsp");
				rd.forward(request, response);
			}
			
			}
	}

}
