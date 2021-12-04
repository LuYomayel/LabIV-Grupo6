<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="Css/MenuAgregarProfesor.css" />
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
	
	<h1><p align="center";" ><b>Agregar Docente </b> </p></h1>
	
	<form action="ServletDocente" method="post" class ="contenedor">
	<table>
	
		<tr>
			<td>Legajo</td><td><input type="text" name="Legajo" class="menu2" ></td>
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
			<td>Localidad</td><td><input type="text" name="txtLocalidad"></td>
		</tr>
		
		<tr>
			<td>Email</td><td><input type="text" name="txtEmail"></td>
		</tr>
		
		<tr>
			<td>Contraseña</td><td><input type="password" name="txtContraseña"></td>
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