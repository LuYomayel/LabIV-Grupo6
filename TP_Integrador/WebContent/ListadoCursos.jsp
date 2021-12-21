<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Materia" %>
<%@page import="Entidad.Docente" %>
<%@page import="DaoImpl.CursoDaoImpl" %> 
<%@page import="DaoImpl.MateriaDaoImpl" %> 
<%@page import="DaoImpl.DocenteDaoImpl" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de cursos</title>
<link rel="Stylesheet" href="Css/ListadoProfesores.css" />
</head>
<body>
<header>
    	 <nav class="menu">
                <ul> 
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
	
	<% 
	ArrayList<Entidad.Curso> listaCursos = null;
	if(request.getAttribute("listaC")!=null){
		listaCursos = (ArrayList<Entidad.Curso>) request.getAttribute("listaC");
	}
 	%>
	<h1><p aling ="Center";"  ><b>Cursos</b></p> </h1>
	
	<form action="ServletCurso" method= "post" class ="contenedor">
		<table border=1 ,style="text-align: center"> 
			<nav class= "table">
				<thead>
		
					<tr>
						<th>Identificacor</th>
						<th>Curso</th>
						<th>Materia</th>
						<th>Carrera</th>
						<th>Semestre</th>
						<th>Año</th>
						<th>Nombre</th>
						<th>Apellido</th>
						
						<th>ELIMINAR</th>
					</tr>
				</thead>
			<tbody>
		
					<tr>
						<%  if(listaCursos!=null)
						for(Curso curso : listaCursos) 
						{
						%>
					<form name="formulario" action="ServletCurso?idCurso=<%=curso.getIdCurso()%>" method="get">
						<td><%= curso.getIdCurso()%>   <input type="hidden" name="idCurso" value="<%=curso.getIdCurso()%>"> </td>
						<td><%= curso.getDescripcion_curso() %></td>
						<td><%= curso.getDescripcion_materia()%></td>
						<td><%= curso.getAño()%></td>
						<td><%= curso.getSemestre()%></td>
						<td><input type="submit" name="btnEliminar" value="Eliminar"></td>
					</form> 
					</tr>
				<%  } %>
		
			</tbody>
			</nav>
			</table>
	
	</form>
	
</body>
</html>