package com.studies.baseapi.todo.application.handler;

import com.studies.baseapi.BaseAPIApplication;
import com.studies.baseapi.shared.BaseHandler;
import com.studies.baseapi.todo.domain.services.TodoService;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ToDoHandler implements BaseHandler {
    Logger logger = LoggerFactory.getLogger(ToDoHandler.class);

    private final TodoService todoService;

    public ToDoHandler(TodoService todoService) {
        this.todoService = todoService;
    }

    private void findOne(HttpServerResponse response, Long id) {
        todoService.findOne(id)
            .onFailure(err -> {

            })
            .onSuccess(res -> doSuccessResponse(res.toBuffer(), response, HttpResponseStatus.OK));
    }

    private void findAll(HttpServerResponse response) {
        todoService.findAll()
            .onFailure(err -> {

            })
            .onSuccess(res -> doSuccessResponse(res.toBuffer(), response, HttpResponseStatus.OK));
    }

    private void doSuccessResponse(Buffer buffer, HttpServerResponse response, HttpResponseStatus status) {
        logger.info("Completed with success");
        response.putHeader("content-type", "application/json");
        response.setStatusCode(status.code());
        response.send(buffer);
    }

    @Override
    public void get(RoutingContext ctx) {
        HttpServerResponse response = ctx.response();
        String id = ctx.pathParam("id");

        if (id == null) {
            findAll(response);
        } else {
            findOne(response, Long.parseLong(id));
        }
    }

    @Override
    public void post(RoutingContext ctx) {

    }

    @Override
    public void put(RoutingContext ctx) {

    }

    @Override
    public void delete(RoutingContext ctx) {

    }
}
