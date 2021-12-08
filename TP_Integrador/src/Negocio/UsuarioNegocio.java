package Negocio;

import java.util.ArrayList;

import Entidad.Usuario;

public interface UsuarioNegocio {
	public int agregarUsuario(Usuario usuario);
	public ArrayList<Usuario> ListarUsuarios();
	public int eliminarUsuario(int id);
	public Alumno obtenerUsuario(int id);
}
