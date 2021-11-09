package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dominio.Docente;
import Dominio.DocenteDao;
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
		
		//AGREGAR DOCENTE
		if(request.getParameter("btnAceptar")!=null){
			if(request.getParameter("txtDni")!=null && request.getParameter("txtNombre")!=null && request.getParameter("txtApellido")!=null && request.getParameter("txtFechaNacimiento")!=null&& request.getParameter("txtDireccion")!=null&& request.getParameter("txtLocalidad")!=null&& request.getParameter("txtNacionalidad")!=null&& request.getParameter("txtEmail")!=null&& request.getParameter("txtTelefono")!=null) {
				int filas =0;
				Docente doc = new Docente();
				
				doc.setDni(request.getParameter("txtDni"));
				doc.setNombre(request.getParameter("txtNombre"));
				doc.setFechanacimiento(request.getParameter("txtFechaNacimiento"));
				doc.setDireccion(request.getParameter("txtDireccion"));
				doc.setLocalidad(request.getParameter("txtLocalidad"));
				doc.setNacionalidad(request.getParameter("txtNacionalidad"));
				doc.setEmail(request.getParameter("txtEmail"));
				doc.setTelefono(request.getParameter("txtTelefono"));
				
				DocenteDao dao = new DocenteDao();
				filas = dao.agregarDocente(doc);
						
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarDocente.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("/AgregarDocente.jsp");
				rd.forward(request, response);
			}
			
			}
			
		}
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnListarDocentes")!=null) {
			DocenteDao dao = new DocenteDao();
			ArrayList<Docente> lista= dao.ListarDocentes();
			request.setAttribute("listita", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarDocentes.jsp");
			rd.forward(request, response);
	}

}
}
