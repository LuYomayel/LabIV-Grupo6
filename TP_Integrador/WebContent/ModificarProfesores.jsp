<%@page import= "Entidad.Docente" %>
<%@page import= "DaoImpl.PaisDaoImpl" %>
<%@page import= "Entidad.Pais" %>
<%@page import= "Entidad.Provincia" %>
<%@page import= "Entidad.Localidad" %>
<%@page import= "java.util.List" %>
<%@page import= "java.util.ArrayList" %>
<%@page import= "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page import= "Entidad.Docente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar docentes</title>
<link rel="Stylesheet" href="Css/ModificarAlumno.css"/>
</head>
<body>
	
	<% 
	ArrayList<Docente> listaDocentes = null;
	if(request.getAttribute("listaD")!=null)
	{
		listaDocentes = (ArrayList<Docente>) request.getAttribute("listaD");
	}
	 %>
	 
	 <header>
    	 <nav class="menu">
                <ul>
                        <li style="width: 276px; "><a href="#"><p align="left">Profesores</p></a>
                        <ul id="desple">
                                <li><a href="ServletDocente?Agregar=1"><p align="left">Agregado de Profesor</p></a></li>
                                <li><a href="ServletDocente?Param=1"><p align="left">Listado de Profesores</p></a></li>
                            </ul>
                            </li><li style="width: 292px; "><a href="#"><p align="left">Alumnos</p></a>
                        <ul id="desple">
                                <li><a href="ServletAlumno?Agregar=1"><p align="left">Agregado de Alumno</p></a></li>
                                <li><a href="ServletAlumno?Param=1"><p align="left">Listado de alumnos</p></a></li>
                            	<li><a href="ServletAlumno?Modificar=1"><p aling="left"> Modificar Alumnos</p> </a> </li>
                            </ul>
                            </li>
                        
                        <li style="width: 335px; "><a href="#"><p align="left">Cursos</p></a>
                        <ul id="desple">
                                <li><a href="ServletCursos?Agregar=1"><p align="left">Agregado de cursado</p></a></li>
                                <li><a href="#"><p align="left">Agregar Alumnos a cursado</p></a></li>
                            </ul>
                            </li>
                        <li><a href="#"><p align="left" style="width: 286px; ">Cerrar Sesion</p></a></li>
                </ul>
            </nav>
	</header>
	 
	 <h1><p aling ="Center";"><b> Modificar Docente</b></p> </h1>
	 <table border= 1>
	 <tr>
	 		<th>Legajo</th>
			<th>Documento</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Direccion</th>
			<th>Localidad</th>
			<th>Nacionalidad</th>
			<th>Provincia</th>
			<th>Email</th>
			<th>Contraseña</th>
			<th>Telefono</th>
			<th>Carrera </th>
			<th>MODIFICAR</th>
	 </tr>
	 
	 <%
   		ArrayList<Pais> list = null;
   		if (request.getAttribute("ListarPais")!=null)
   		{
 			list = (ArrayList<Pais>) request.getAttribute("ListarPais");
   		}
     %>
     <%
   		ArrayList<Provincia> listprov = null;
     	if(request.getAttribute("ListarProvincia")!=null){
    		listprov= (ArrayList<Provincia>) request.getAttribute("ListarProvincia");}
     %>
	 <%				
		   ArrayList<Localidad> listLocalidad = null;
		    if(request.getAttribute("ListarLocalidad")!=null){
		    	listLocalidad = (ArrayList<Localidad>) request.getAttribute("ListarLocalidad");}
		%>
		
		<% if(listaDocentes!=null)
		for(Docente docente : listaDocentes) {
		%>	
		<tr>
					<form name="formulario" action="ServletDocente?idDocente=<%=docente.getLegajo()%>" method="get">
			<form action="ServletDocente" method = "post">
					<td><%= docente.getLegajo()%> <input type="hidden" name="idDocente" value="<%=docente.getLegajo()%>"> </td>
					<td><input type ="text" name ="dniDocente" value= "<%=docente.getDni() %>"> </td>
					<td><input type ="text" name ="NombreDocente" value= "<%=docente.getNombre() %>"></td>
					<td><input type ="text" name ="ApellidoDocente" value= "<%=docente.getApellido() %>"></td>
					<td><input type ="text" name ="NacDocente" value= "<%=docente.getFechanacimiento() %>"></td>
					<td><input type ="text" name ="DireccionDocente" value= "<%=docente.getDireccion() %>"></td>
					<td><input type ="text" name ="PaisDocente" value= "<%=docente.getNacionalidad() %>"></td>
					<td><input type ="text" name ="ProvinciaDocente" value= "<%= docente.getProvincia()%>"></td>
					<td><input type ="text" name ="LocalidadDocente" value= "<%=docente.getLocalidad() %>"></td>
					<td><input type ="text" name ="EmailDocente" value= "<%=docente.getEmail() %>"></td>

					<td><input type ="text" name ="contraseñaDocente" value= "<%=docente.getContraseña() %>"></td>

					<td><input type ="text" name ="TelefonoDocente" value= "<%=docente.getTelefono() %>"></td>
					<td><input type ="text" name ="CarreraDocente" value= "<%=docente.getIdCarrera() %>"></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
			</form>
			</tr>
			 
		 <%  } %>    
	 </table>
	 </form>
</body>
</html>