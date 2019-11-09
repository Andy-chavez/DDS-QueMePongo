package controllers;
import models.entities.*;
import models.entities.Guardarropa;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
import models.repositorios.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

package app.login;

import app.user.*;
import app.util.*;
import spark.*;
import java.util.*;
import static app.util.RequestUtil.*;
public class LoginController {

    public static ModelAndView serveLoginPage(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("loggedOut", request.session().removeAttribute());
        parametros.put("loginRedirect", removeSessionAttrLoginRedirect(request));
        return new ModelAndView(parametros, "login");
    }


    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        if (!UserController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, Path.Template.LOGIN);
        }
        model.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", getQueryUsername(request));
        if (getQueryLoginRedirect(request) != null) {
            response.redirect(getQueryLoginRedirect(request));
        }
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };


    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(Path.Web.LOGIN);
        return null;
    };


    // The origin of the request (request.pathInfo()) is saved in the session so
    // the user can be redirected back after login
    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect(Path.Web.LOGIN);
        }
    };

}