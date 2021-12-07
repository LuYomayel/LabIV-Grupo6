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
import Entidad.Alumno;
import Entidad.Docente;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregar")!=null){
			if(request.getParameter("txtDni")!=null && request.getParameter("txtNombre")!=null && request.getParameter("txtApellido")!=null && request.getParameter("txtFecha")!=null && request.getParameter("txtNacionalidad")!=null && request.getParameter("txtLocalidad")!=null && request.getParameter("txtEmail")!=null && request.getParameter("txtTelefono")!=null && request.getParameter("txtContraseña")!=null) {
				int filas =0;
				Docente doc = new Docente();
				
				doc.setLegajo(1000);
				doc.setDni(request.getParameter("txtDni"));
				doc.setNombre(request.getParameter("txtNombre"));
				doc.setApellido(request.getParameter("txtApellido"));
				doc.setFechanacimiento(request.getParameter("txtFecha"));
				doc.setDireccion(request.getParameter("txtDireccion"));
				doc.setNacionalidad(request.getParameter("txtNacionalidad"));
				doc.setLocalidad(request.getParameter("txtLocalidad"));
				
				doc.setEmail(request.getParameter("txtEmail"));
				doc.setTelefono(request.getParameter("txtTelefono"));
				
				DocenteDaoImpl dao = new DocenteDaoImpl();
				filas = dao.agregarDocente(doc);
						
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("/ListadoAlumnos.jsp");
				rd.forward(request, response);
			}
			
			}
		
			if(request.getParameter("btnListarDocentes")!=null) {
				DocenteDaoImpl dao = new DocenteDaoImpl();
				ArrayList<Docente> lista= dao.ListarDocentes();
				request.setAttribute("listita", lista);
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoProfesores.jsp");
				rd.forward(request, response);
			}
	}

}
