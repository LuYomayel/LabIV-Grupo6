package Negocio;

import java.util.ArrayList;

import Entidad.Usuario;
import Entidad.Docente;

public interface UsuarioNegocio {
	public int obtenerUsuario(Usuario usuario);
	public boolean obtenerAdmin (Usuario usuario);
	public void agregarDocente(Docente docente);
	public int Baja(Usuario u);
}
