package com.studies.baseapi;

import com.studies.baseapi.shared.BaseHandler;
import com.studies.baseapi.todo.application.handler.ToDoHandler;
import com.studies.baseapi.todo.domain.services.TodoService;
import com.studies.baseapi.todo.domain.services.TodoServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseAPIApplication extends AbstractVerticle {
    Logger logger = LoggerFactory.getLogger(BaseAPIApplication.class);

    private BaseHandler handler;
    private TodoService todoService;


    public BaseAPIApplication() {
        Vertx v = Vertx.vertx();
        this.init(v, v.getOrCreateContext());
    }

    private void startSingletons() {
        todoService = new TodoServiceImpl();
    }

    private void startHandlers() {
        handler = new ToDoHandler(todoService);
    }

    private void init() {
        startSingletons();
        startHandlers();
    }


    private Router startRoutes() {
        Router router = Router.router(vertx);

        router
            .get("/api/v1")
            .handler(handler::get);

        router
            .get("/api/v1/:id")
            .handler(handler::get);

        router
            .post("/api/v1")
            .handler(handler::post);

        router
            .put("/api/v1/:id")
            .handler(handler::put);

        router
            .delete("/api/v1/:id")
            .handler(handler::delete);

        return router;
    }

    @Override
    public void start() {
        init();

        Promise<Void> promise = Promise.promise();

        vertx.createHttpServer()
            .requestHandler(startRoutes())
            .listen(8080, http -> {
                if (http.succeeded()) {
                    promise.complete();
                    logger.info("HTTP server started on port 8080");
                } else {
                    promise.fail(http.cause());
                }
        });
    }

    public static void main(String[] args) throws Exception {
        new BaseAPIApplication().start();
    }
}


