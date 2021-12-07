/*Listado de Alumnos*/
SELECT a.Legajo, a.Dni, a.Nombre, a.Apellido, a.FechaNac, a.Direccion,
pa.descripcion AS Nacionalidad, pr.descripcion AS Provincia, 
lo.descripcion AS Localidad, c.Descripcion_carrera FROM alumnos a
JOIN carreras c ON a.idCarrera = c.idCarrera 
JOIN paises pa ON a.idPais = pa.idPais
JOIN provincias pr ON a.idProvincia = pr.idProvincia
JOIN localidades lo ON a.idLocalidad = lo.idLocalidad;

/*Listado Profesores*/
SELECT d.Legajo, d.Dni, d.Nombre, d.Apellido, d.FechaNac, d.Direccion,
pa.descripcion AS Nacionalidad, pr.descripcion AS Provincia, 
lo.descripcion AS Localidad, c.Descripcion_carrera FROM docentes d
JOIN carreras c ON d.idCarrera = c.idCarrera
JOIN paises pa ON d.idPais = pa.idPais
JOIN provincias pr ON d.idProvincia = pr.idProvincia
JOIN localidades lo ON d.idLocalidad = lo.idLocalidad; 

/*Listado de Cursos */
SELECT c.idCurso,m.Descripcion_Materia, c.Descripcion_curso, c.Semestre,
 c.Año, d.Nombre, d.Apellido, car.Descripcion_carrera FROM cursos c
LEFT JOIN materias m ON c.idMateria = m.idMateria
LEFT JOIN docentes d ON c.idDocente = d.idDocente
LEFT JOIN carreras car ON d.idCarrera = car.idCarrera;

/*alumnosxcurso en general*/
SELECT axc.idAlumnosxcurso,a.Nombre, a.Apellido,c.Descripcion_curso, axc.estado, axc.parcial1, axc.parcial2, axc.recuperatorio1, 
axc.recuperatorio2 FROM  alumnosxcurso axc
LEFT JOIN cursos c ON axc.idCurso = c.idCurso
LEFT JOIN docentes d ON c.idDocente = d.idDocente
LEFT JOIN alumnos a ON axc.idAlumno = a.idAlumno;


/****Hacer Stored procedures****/
/*Materias que tiene una carrera
(El administrador para inscrir el docente a un curso 
de una Materia -antes tiene que ver si esa materia está en la carrera donde figura el docente
)Si un profesor se inscribió a una materia que no esta en determinada carrera, 
hay que modificar el campo idCarrera del Docente(NOT NULL) y modificar el campo idDocente(not null) 
de un registro de la tabla cursos, en el supuesto podria darse de baja el registro de curso y 
volverlo a crear con los datos actualizados. Controlar en los JSP que no se muestren varios registros repitiendo la carrera.*/
SELECT car.Descripcion_carrera,m.Descripcion_Materia FROM materiasxcarrera mxc
LEFT JOIN  carreras car ON  mxc.idCarrera_Mat = car.idCarrera
LEFT JOIN materias m ON  mxc.IdMateria_Mat = m.idMateria
ORDER BY car.idCarrera ASC;

/*Cursos de un determinado docente*/
SELECT c.idCurso,m.Descripcion_Materia, c.Descripcion_curso, c.Semestre,
 c.Año, d.Nombre, d.Apellido, car.Descripcion_carrera FROM cursos c 
LEFT JOIN materias m ON c.idMateria = m.idMateria
LEFT JOIN docentes d ON c.idDocente = d.idDocente
LEFT JOIN carreras car ON d.idCarrera = car.idCarrera
WHERE d.Legajo="123456";


/*alumnosxcurso Profesor solicita ver Un alumno en Un determinado curso
(Evitar que un alumno se inscriba dos veces al mismo curso) Esto se chequea fuera de la base*/
SELECT axc.idAlumnosxcurso,a.Nombre, a.Apellido,c.Descripcion_curso, axc.estado, axc.parcial1, axc.parcial2, axc.recuperatorio1, 
axc.recuperatorio2 FROM  alumnosxcurso axc
LEFT JOIN cursos c ON axc.idCurso = c.idCurso
LEFT JOIN docentes d ON c.idDocente = d.idDocente
LEFT JOIN alumnos a ON axc.idAlumno = a.idAlumno
WHERE a.Legajo = 12111 AND c.idCurso=1;

SELECT axc.idAlumnosxcurso,a.Nombre, a.Apellido,c.Descripcion_curso, axc.estado, axc.parcial1, axc.parcial2, axc.recuperatorio1, 
axc.recuperatorio2 FROM  alumnosxcurso axc
LEFT JOIN cursos c ON axc.idCurso = c.idCurso
LEFT JOIN docentes d ON c.idDocente = d.idDocente
LEFT JOIN alumnos a ON axc.idAlumno = a.idAlumno
WHERE a.Legajo LIKE '%12111%' AND c.idCurso LIKE '%1%';

/*Manejar bajas lógicas y no físicas ¿que significa? 
¿que no se borren los registros en la base de datos pero si en los JSP (carga de datos)?*/





/*Procedimientos almacenados*/
/*delimiter PRIMER EJECUCION*/
/*create procedure ... hasta end $$ SEGUNDA EJECUCION*/
delimiter $$  
CREATE PROCEDURE insertar_alumno (  _legajo int ,_dni int, _nombre varchar(45), _apellido varchar(45),
_FechaNac varchar(45), _direccion varchar(45), _idpais int, _idprovincia int, _idlocalidad int, _email varchar(45),
_telefono int, _idcarrera int)
	begin 				
	insert into alumnos(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, idPais, idProvincia, 
    idLocalidad, Email, Telefono, idCarrera)
		values(_legajo ,_dni, _nombre, _apellido, _FechaNac, _direccion, _idpais, 
        _idprovincia, _idlocalidad, _email, _telefono, _idcarrera);
	end  $$


CREATE PROCEDURE borrar_alumno( in legajo int)
begin
	DELETE FROM ALUMNOS WHERE Legajo = legajo;
end $$

delimiter $$  
CREATE PROCEDURE actualizar_alumno (  legajo int ,dni int, nombre varchar(45), apellido varchar(45),
fechanac varchar(45), direccion varchar(45), idpais int, idprovincia int, idlocalidad int, email varchar(45),
telefono int, idcarrera int)
	begin 				
	update alumnos
    set Dni = dni, Nombre = nombre, Apellido = apellido, FechaNac = fechanac, 
    Direccion = direccion, idPais = idpais, idProvincia = idprovincia, idLocalidad = idlocalidad, 
    Email = email, Telefono = telefono, idCarrera = idcarrera
    where Legajo = legajo;
	end  $$
    
/* Legajo es Unique por lo que no puede actualizarse porque no debe duplicarse
Funcionamiento SP insertar_alumno, etc... TERCERA EJECUCION*/
call insertar_alumno(12126, 40016, 'Leonela', 'Flores', '2000-01-01', 'Danford 42768', 2,2,2, 'lioflores@dominio.com', 352363623, 1); 
call insertar_alumno(12127, 40017, 'Leone', 'Flo', '2000-01-01', 'Danfos 42768', 2,2,2, 'liofres@dominio.com', 35633323, 1);

call borrar_alumno(12127); /*Error Code: 1175. you are using safe update mode and you tried to update... */

call actualizar_alumno(12127, 40017, 'Leone2', 'Flo', '2000-01-01', 'Danfos 42768', 2,2,2, 'liofres@dominio.com', 35633323, 1);
/*Error Code: 1175. you are using safe update mode and you tried to update... */








