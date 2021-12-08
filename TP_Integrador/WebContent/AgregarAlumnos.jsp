<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import ="java.util.*" %>
<%@page import="Entidad.Alumno" %>
<%@page import="DaoImpl.PaisDaoImpl" %>
<%@page import="Entidad.Pais" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<form action="ServletAlumno" method="post" class ="contenedor" action ="ServeletPais">
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
			<td>Documento</td><td><input type="text" name="txtDni" required></td>
		</tr>
		<tr>
			<td>Nombre</td><td><input type="text" name="txtNombre"required></td>
		</tr>
		<tr>
			<td>Apellido</td><td><input type="text" name="txtApellido" required></td>
		</tr>
		<tr>
			<td>Fecha de Nacimiento</td><td><input type="text" name="txtFecha"required></td>
		</tr>
		<tr>

		<td> Nacionalidad</td>
		<td>
			<select name="Nacionalidad" style="width: 148px ; ">  
	<%
   		ArrayList<Pais> list = null;
   		if (request.getAttribute("listarPais")!=null)
   		{
   				list = (ArrayList<Pais>) request.getAttribute("listarPais");
   				}
     %>
     <option value=null selected disabled hidden>Elegir un Pais</option>
     <%for(Pais t : list){
     	 
    	 %>	
		<option ><%= t.getDescripcionPais() %> </option>
		
		<%} 
		%>
		
	</select>
	</td>
		</tr>
		<tr>
			<td>Provincia</td>
			<td>
			<select name="Provincia" style="width: 148px; " > 
				<%-- 
	<%

   ArrayList<Provincia> list = new ArrayList<Provincia>();

     if(request.getAttribute("ListaProvincia")!=null){
    	 list= (ArrayList<Provincia>) request.getAttribute("ListaProvincia");}
     %>
     <option value=null selected disabled hidden>Elegir una Provincia</option>
     <%for(Provincia t : list){
     	 
    	 %>
     
	
		<option ><%=t.getDescripcion()%></option>
		
		<%} %>
		--%>
			</select>
			</td>
		</tr>
		<tr>
			<td>Localidad</td>
			<td>
			<select select name="Localidad" style="width: 148px; " >
			<%-- 
			<%
				int i=0;
		   		ArrayList<Localidad> list = new ArrayList<Localidad>();
		
		     if(request.getAttribute("ListaLocalidad")!=null){
		    	 list= (ArrayList<Localidad>) request.getAttribute("ListaLocalidad");}
		     %>
		     <option value=null selected disabled hidden>Elegir una Localidad</option>
		     <%for(Localidad t : list){
		     	 
		    	 %>
		     
			
				<option ><%=t.getDescripcion_Localidad()%></option>
				
				<%} %>
		--%>	
			</select>
			</td>
		</tr>
		
		<tr>
			<td>Direccion</td><td><input type="text" name="txtDireccion"required></td>
		</tr>
		<tr>
			<td>Email</td><td><input type="text" name="txtEmail"required></td>
		</tr>
		<tr>
			<td>Telefono</td><td><input type="text" name="txtTelefono"required></td>
		</tr>
		<tr>
			<td><input type="Submit" name="btnAgregar" value="AGREGAR" style="color: #000000"></td>
		</tr>
		
	</table>
	</form>
	<%
	int filas=0;
	if(request.getAttribute("fila") != null)
		filas = (int)request.getAttribute("fila");
%>
<% if(filas == 1){ %>
			<b>¡Alumno agregado con exito! </b>
			<%} %>
	
</body>
</html>