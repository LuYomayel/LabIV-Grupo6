<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de alumnos</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
</head>
<body>
	<header>
    	 <nav class="menu">
                <ul>
                        <li style="width: 276px; "><a href="#"><p align="left">Profesores</p></a>
                        <ul id="desple">
                                <li><a href="AgregarProfesores.jsp"><p align="left">Agregado de Profesor</p></a></li>
                                <li><a href="ListadoProfesores.jsp"><p align="left">Listado de Profesores</p></a></li>
                            </ul>
                            </li><li style="width: 292px; "><a href="#"><p align="left">Alumnos</p></a>
                        <ul id="desple">
                                <li><a href="AgregarAlumnos.jsp"><p align="left">Agregado de Alumno</p></a></li>
                                <li><a href="ListadoAlumnos.jsp"><p align="left">Listado de alumnos</p></a></li>
                            </ul>
                            </li>
                        
                        <li style="width: 335px; "><a href="#"><p align="left">Cursos</p></a>
                        <ul id="desple">
                                <li><a href="#"><p align="left">Agregado de cursado</p></a></li>
                                <li><a href="#"><p align="left">Agregar Alumnos a cursado</p></a></li>
                            </ul>
                            </li>
                        <li><a href="#"><p align="left" style="width: 286px; ">Cerrar Sesion</p></a></li>
                </ul>
            </nav>
            
	</header>
	
	<h1><p aling ="Center";"  ><b> Listar Alumno</b></p> </h1>
	<form action="ServeletAlumno" method= "post" class ="contenedor">
		<table border=1 ,style="text-align: center"> 
		<nav class= "table">
		<tr>
			<th>Legajo</th>
			<th>Documento</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Nacionalidad</th>
			<th>Provincia</th>
			<th>Direccion</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>ELIMINAR</th>
		</tr>
		
				<tr>

					<td>a.Legajo</td>
					<td>a.Documento</td>
					<td>a.Nombre</td>
					<td>a.Apellido</td>
					<td>a.FechaNac</td>
					<td>a.Nacionalidad</td>
					<td>a.Provincia</td>
					<td>a.Direccion</td>
					<td>a.Email</td>
					<td>a.Telefono</td>
					<td>BOTON ELIMINAR</td>
				</tr>
			</nav>
	</table>
	
	</form>
	
	
</body>
</html>