package server;

import controllers.*;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){

        UsuarioController usuarioController = new UsuarioController();
        GuardarropaController guardarropaController = new GuardarropaController();
        EventoController eventoController = new EventoController();
        PrendaController prendaController = new PrendaController();
        TipoController tipoController = new TipoController();
        AtuendoController atuendoController = new AtuendoController();
        LoginController loginController = new LoginController();

        Spark.get("/crearPrenda", prendaController::pantallaDeCreacion, Router.engine);
      
        Spark.get("/eleccionDeCategoria", prendaController::eleccionDeCategoria, Router.engine);

        Spark.get("/tiposPorCategoria", tipoController::buscarPorCategoria, Router.engine);
      
        Spark.get("/login", loginController::serveLoginPage, Router.engine);
        Spark.post("/login", loginController::handleLoginPost, Router.engine);
        Spark.post("/logout", loginController::handleLogoutPost, Router.engine);

        Spark.get("/", guardarropaController::mostrarTodos, Router.engine);

        Spark.get("/guardarropas", guardarropaController::mostrarTodos, Router.engine);
        Spark.get("/guardarropas/:idGuardarropa/prendas", guardarropaController::mostrar, Router.engine);
        Spark.get("/guardarropas/:idGuardarropa/prendas/new", guardarropaController::crear, Router.engine);
        Spark.delete("/guardarropas/:idGuardarropa/prendas/:idPrenda", prendaController::eliminar);

        // DATO: eventos/new tiene que declararse antes que eventos/:id porque sino, cuando se escriba el url, piensa que "new" es un id
        Spark.get("/eventos", eventoController::mostrarTodos, Router.engine);
        Spark.get("/eventos/new", eventoController::crearEvento, Router.engine);
        Spark.post("/eventos/new", eventoController::guardarEvento);
        Spark.get("/eventos/:idEvento", eventoController::mostrar, Router.engine);

        Spark.get("/atuendos", atuendoController::mostrarTodos, Router.engine);

//
//        Spark.after((req, res) -> {
//            PerThreadEntityManagers.closeEntityManager();
//        });
    }
}
