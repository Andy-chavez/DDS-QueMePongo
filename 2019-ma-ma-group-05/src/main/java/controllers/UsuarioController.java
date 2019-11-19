package controllers;

import models.entities.Usuario;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {
    private static RepositorioUsuario repo;
    public UsuarioController(){
        this.repo = RepositorioUsuario.getInstance();
    }

    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        Usuario user = repo.buscarPorNombre(username);

        if (user == null) {
            return false;
        }
//        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
//        return hashedPassword.equals(user.getHashedPassword());
//        return user.getContraseña().equals(password);
        return user.getNombre().equals(username);
    }

    public static int getID(String username){
        Usuario user = repo.buscarPorNombre(username);
        return user.getId();
    }
}
