package Dao;

import Entidad.Usuario;

public interface UsuarioDao {
	public int obtenerUsuario(Usuario usuario);
	public boolean obtenerAdmin (Usuario usuario);
}
