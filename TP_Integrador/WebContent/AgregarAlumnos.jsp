<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Alumnos</title>
<link rel="Stylesheet" href="Css/MenuAgregarAlumno.css" />
</head>
<body>
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
	
	<h1><p align="center";" ><b>Agregar Alumnos </b> </p></h1>
	
	<form action="ServletAlumno" method="post" class ="contenedor">
	<table>
	<% 
	int legajo=1000;
	if(request.getAttribute("legajo")!=null)
	{
		legajo = (int)request.getAttribute("legajo");
	}

 	%>
		<tr>
			<td>Legajo</td><td><input type="text" name="Legajo" class="menu2" value="<%=legajo%>" readonly="true"></td>
		</tr>
		<tr>
			<td>Documento</td><td><input type="text" name="txtDni"></td>
		</tr>
		<tr>
			<td>Nombre</td><td><input type="text" name="txtNombre"></td>
		</tr>
		<tr>
			<td>Apellido</td><td><input type="text" name="txtApellido"></td>
		</tr>
		<tr>
			<td>Fecha de Nacimiento</td><td><input type="text" name="txtFecha"></td>
		</tr>
		<tr>
			<td>Nacionalidad</td><td><input type="text" name="txtNacionalidad"></td>
		</tr>
		<tr>
			<td>Provincia</td><td><input type="text" name="txtProvincia"></td>
		</tr>
		
		<tr>
			<td>Direccion</td><td><input type="text" name="txtDireccion"></td>
		</tr>
		<tr>
			<td>Email</td><td><input type="text" name="txtEmail"></td>
		</tr>
		<tr>
			<td>Telefono</td><td><input type="text" name="txtTelefono"></td>
		</tr>
		<tr>
			<td><input type="Submit" name="btnAgregar" value="AGREGAR" style="color: #000000"></td>
		</tr>
		
	</table>
	</form>
</body>
</html>