package server;

import controllers.EventoController;
import controllers.PrendaController;
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

        PrendaController prendaController = new PrendaController();
        EventoController eventoController = new EventoController();
//        Spark.get("/usuarios", usuarioController::mostrarTodos, Router.engine);
//
        Spark.get("/:idUsuario/:idGuardarropa", prendaController::mostrarTodos, Router.engine);
        Spark.delete("/idUsuario/:idGuardarropa/:idPrenda", prendaController::eliminar);
        Spark.delete("/usuario/guardarropa/:idPrenda", prendaController::eliminar);

        Spark.get("/:idUsuario/eventos", eventoController::mostrarTodos, Router.engine);
        Spark.get("/:idUsuario/:idEvento", eventoController::mostrar, Router.engine);

//        Spark.get("/usuario", usuarioController::crear, Router.engine);
//
//        Spark.post("/usuario/:id", usuarioController::modificar);
//
//        Spark.post("/usuario", usuarioController::guardar);
//
//        Spark.delete("/usuario/:id", usuarioController::eliminar);
//
//        Spark.after((req, res) -> {
//            PerThreadEntityManagers.closeEntityManager();
//        });
    }
}
