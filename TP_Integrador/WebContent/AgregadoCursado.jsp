<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Materia" %>
<%@page import="Entidad.Docente" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="Css/MenuAgregarProfesor.css" />
<title>Agregar cursado</title>
</head>
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
                               <li><a href="ServletCursos?Agregar=1"><p align="left">Agregado de cursado</p></a></li>
                               <li><a href="#"><p align="left">Agregar Alumnos a cursado</p></a></li>
                           </ul>
                           </li>
                       <li><a href="#"><p align="left" style="width: 286px; ">Cerrar Sesion</p></a></li>
               </ul>
	</nav>
            
</header>
<body>
	<%
		ArrayList<Materia> list = null;
		if (request.getAttribute("listaMaterias")!=null)
		{
		list = (ArrayList<Materia>) request.getAttribute("listaMaterias");
		}
	%>
	<form method="get" action="ServletCursos">
		<label>Materias: </label>
		<select id ="Materias" name="Materias" style="width: 148px ; ">  
							<option value=null selected disabled hidden>Elegir una Materia</option>
						     	<% 
						     	if (list!= null)
					     		for(Materia t : list){
					    	 	%>	
								<option value=<%= t.getIdMateria() %> ><%= t.getNombreMateria()%> </option>
								<% } %>
						</select>
	</form>
</body>
</html>