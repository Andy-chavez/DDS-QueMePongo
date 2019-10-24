package models.DAOs;

import models.entities.Usuario;

import java.util.List;

public interface DAO {
    public Object buscarPorId(int id);
    public Object buscarPorNombre(String nombre);
    public List<Object> buscarTodos();
    public void modficarPorId(int id, Object o);
    public void eliminar(Object o);
    public void agregar(Object o);

}
