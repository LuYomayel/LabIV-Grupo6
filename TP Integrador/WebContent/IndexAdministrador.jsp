<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IndexAdministrador</title>
   <link rel="Stylesheet" href="CssStyles/MenuAdministrador.css" />
</head>

<body>

        <header>
            <input type="checkbox" id="btnMenu">
            <label for="btnMenu"></label>
            <nav class="menu">
                <ul>
                        <li><a href="#">Profesores</a>
                        <ul id="desple">
                                <li><a href="#">Agregado de Profesor</a></li>
                                <li><a href="#">Listado de Profesores</a></li>
                            </ul>
                            </li>
                        <li><a href="#">Alumnos</a>
                        <ul id="desple">
                                <li><a href="#">Agregado de Alumno</a></li>
                                <li><a href="#">Listado de alumnos</a></li>
                            </ul>
                            </li>
                        <li><a href="#">Cursos</a>
                        <ul id="desple">
                                <li><a href="#">Agregado de cursado</a></li>
                                <li><a href="#">Agregar Alumnos a cursado</a></li>
                            </ul>
                            </li>
                       
                       
                        <li><a href="#">Cerrar Sesion</a></li>
                </ul>

            </nav>
        </header>
       
   
</body>
</html>