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
        //Spark.get("/quemepongo",usuarioController::pantallaDeInicio, Router.engine);

        Spark.get("/:idUsuario/:idGuardarropa", prendaController::mostrarTodos, Router.engine);

        Spark.delete("/guardarropa/:idPrenda", prendaController::eliminar);
        Spark.get("/guardarropas", guardarropaController::mostrarTodos, Router.engine);
//        Spark.get("/:idUsuario/guardarropas", guardarropaController::mostrarTodos, Router.engine);
        Spark.get("/:idUsuario/eventos", eventoController::mostrarTodos, Router.engine);
        Spark.get("/:idUsuario/:idEvento", eventoController::mostrar, Router.engine);
        Spark.post("/crearEvento", eventoController::guardarEvento);
        Spark.get("/crearEvento", eventoController::crearEvento, Router.engine);

        Spark.get("/calificarAtuendos", atuendoController::mostrarTodos, Router.engine);
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
