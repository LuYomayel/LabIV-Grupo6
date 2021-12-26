<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoxcursoDaoImpl"%>
<%@page import="Entidad.Alumnoxcurso" %>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@page import="Entidad.Alumno" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Notas</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
</head>
<body>
	<head>
		<nav class="menu">
			<ul>           
                        <li style="width: 335px; "><a href="#"><p align="left">Cursos</p></a>
                        <ul id="desple">
                                <li><a href="ServletAlumnoxcurso?Agregar=1"><p align="left">Agregado de cursado</p></a></li>
                                <li><a href="#"><p align="left">Agregar Alumnos a cursado</p></a></li>
                                <li><a href="ServletAlumnoxcurso?Param=1"><p align="left">Listado de Alumnos por curso</p></a></li>
                            </ul>
                            </li>
                        <li><a href="#"><p align="left" style="width: 286px; ">Cerrar Sesion</p></a></li>
                </ul>
		</nav>
	</head>
	
	<%
	ArrayList<Alumnoxcurso> listaAlumnosxc = null;
	if(request.getAttribute("listaAxc")!=null)
	{
		listaAlumnosxc = (ArrayList<Alumnoxcurso>) request.getAttribute("listaAxc");
	}
	%>
	
	<h1><p aling ="Center";"  ><b> Listado de alumnos por curso</b></p> </h1> <!-- probablemente servlet diferente-->
	<form action="ServeletAlumnoxcurso" method= "post" class ="contenedor"> 
		<table border=1 ,style="text-align: center"> 
		<nav class= "table">
		<thead>
		
		<tr>
			<th>Legajo</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Curso</th>
			<th>Nota 1</th>
			<th>Nota 2</th>
			<th>Recuperatorio Nota 1</th>
			<th>Recuperatorio Nota 2</th>
			<th>Estado</th>
			
		</tr>
		</thead>
		<tbody>
		<% if(listaAlumnosxc!=null)	
		for(Alumnoxcurso alumnoxcurso : listaAlumnosxc) 
		{
		%>	
		<tr>
			<form name="formulario" action="ServletAlumno?idAlumno=<%--=alumno.getLegajo()--%>" method="get">
				

					<%-- <td><%= //alumnoxc.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=//alumnoxc.getLegajo()%>"> </td>
					<td><%= //alumnoxc.getNombre()%></td>
					<td><%= //alumnoxc.getCurso()%></td>
					<td><%= //alumnoxc.getNota1()%></td>
					<td><%= //alumnoxc.getNota2()%></td>
					<td><%= //alumnoxc.getRecup1()%></td>
					<td><%= //alumnoxc.getRecup2()%></td>
					<td><%= //alumnoxc.getEstado()--%></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
				
				</form> 
				</tr>
				<% } %>
		</tbody>
			</nav>
	</table>
	
	</form>
</body>
</html>