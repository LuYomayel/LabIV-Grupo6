<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="Entidad.Alumno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifcar alumnos</title>
<link rel="Stylesheet" href="Css/ModificarAlumno.css" />
</head>
<body>	

	<% 
	ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaA")!=null)
	{
		listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaA");
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

	<h1><p aling ="Center";"  ><b> Modificar Alumno</b></p> 
</h1>
		<table border=1> 
		<tr>
			<th>Legajo</th>
			<th>Documento</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Direccion</th>
			<th>Nacionalidad</th>
			<th>Provincia</th>
			<th>Localidad</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Carrera </th>
			<th>MODIFICAR</th>
		</tr>
		<%  if(listaAlumnos!=null)
		for(Alumno alumno : listaAlumnos) 
		{
			%>	
		<tr>
					<form name="formulario" action="ServletAlumno?idAlumno=<%=alumno.getLegajo()%>" method="get">
			<form action="ServletAlumno" method = "post">
					<td><%= alumno.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=alumno.getLegajo()%>"> </td>
					<td><input type ="text" name ="dniAlumno" value= "<%=alumno.getDni() %>"> </td>
					<td><input type ="text" name ="NombreAlumno" value= "<%=alumno.getNombre() %>"></td>
					<td><input type ="text" name ="ApellidoAlumno" value= "<%=alumno.getApellido() %>"></td>
					<td><input type ="text" name ="NacAlumno" value= "<%=alumno.getFechanacimiento() %>"></td>
					<td><input type ="text" name ="DireccionAlumno" value= "<%=alumno.getDireccion() %>"></td>
					<td><input type ="text" name ="PaisAlumno" value= "<%=alumno.getNacionalidad() %>"></td>
					<td><input type ="text" name ="ProvinciaAlumno" value= "<%= alumno.getProvincia()%>"></td>
					<td><input type ="text" name ="LocalidadAlumno" value= "<%=alumno.getLocalidad() %>"></td>
					<td><input type ="text" name ="EmailAlumno" value= "<%=alumno.getEmail() %>"></td>
					<td><input type ="text" name ="TelefonoAlumno" value= "<%=alumno.getTelefono() %>"></td>
					<td><input type ="text" name ="CarreraAlumno" value= "<%=alumno.getIdCarrera() %>"></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
			</form>
				</tr>
			<%  } %>
	</table>

	</form>
</body>

</html>