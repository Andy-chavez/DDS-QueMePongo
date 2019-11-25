package controllers;

import models.entities.Guardarropa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import spark.*;


public class LoginController {

    private static boolean removeSessionAttrLoggedOut(Request request) {
        Object loggedOut = request.session().attribute("loggedOut");
        request.session().removeAttribute("loggedOut");
        return loggedOut != null;
    }

    private static String removeSessionAttrLoginRedirect(Request request) {
        String loginRedirect = request.session().attribute("loginRedirect");
        request.session().removeAttribute("loginRedirect");
        return loginRedirect;
    }
    public ModelAndView serveLoginPage (Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("loggedOut", removeSessionAttrLoggedOut(request));
        parametros.put("loginRedirect", removeSessionAttrLoginRedirect(request));
        return new ModelAndView(parametros, "login.hbs");
    }


    public ModelAndView handleLoginPost(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        if (!UsuarioController.authenticate(request.queryParams("username"), request.queryParams("password"))) {
            parametros.put("authenticationFailed", true); // esta variable esta para usar de condicion y tirar algun msj de error en el html
            return new ModelAndView(parametros, "login.hbs");
        }
        parametros.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", UsuarioController.getID(request.queryParams("username")));
        if (request.queryParams("loginRedirect") != null) {
            response.redirect(request.queryParams("loginRedirect"));
        }
        response.redirect("/");
        return null;
    }


    public ModelAndView handleLogoutPost(Request request, Response response){
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect("login");
        return null;
    }


    // The origin of the request (request.pathInfo()) is saved in the session so
    // the user can be redirected back after login
    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect("/login");
        }
    };

}