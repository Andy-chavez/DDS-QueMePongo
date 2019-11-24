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
        AtuendoController atuendoController = new AtuendoController();
        LoginController loginController = new LoginController();
      
        Spark.get("/crearPrenda", prendaController::pantallaDeCreacion, Router.engine);
      
        Spark.get("/eleccionDeCategoria", prendaController::eleccionDeCategoria, Router.engine);
      
      
        Spark.get("/login", loginController::serveLoginPage, Router.engine);
        Spark.post("/login", loginController::handleLoginPost, Router.engine);
        Spark.post("/logout", loginController::handleLogoutPost, Router.engine);

        Spark.get("/:idGuardarropa", prendaController::mostrarTodos, Router.engine);
        Spark.get("/", guardarropaController::mostrarTodos, Router.engine);
        Spark.delete("/guardarropa/:idPrenda", prendaController::eliminar);
        Spark.get("/eventos", eventoController::mostrarTodos, Router.engine);
        Spark.get("/eventos/:idEvento", eventoController::mostrar, Router.engine);
        Spark.get("/crearEvento", eventoController::crearEvento, Router.engine);
        Spark.post("/crearEvento", eventoController::guardarEvento);

        Spark.get("/calificarAtuendos", atuendoController::mostrarTodos, Router.engine);

//
//        Spark.after((req, res) -> {
//            PerThreadEntityManagers.closeEntityManager();
//        });
    }
}
