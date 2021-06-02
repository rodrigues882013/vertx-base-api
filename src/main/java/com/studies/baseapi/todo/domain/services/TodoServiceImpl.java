package com.studies.baseapi.todo.domain.services;

import com.studies.baseapi.todo.application.handler.ToDoHandler;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoServiceImpl implements TodoService {
    Logger logger = LoggerFactory.getLogger(ToDoHandler.class);

    @Override
    public Future<JsonObject> findOne(Long id) {
        logger.info("Find by id");
        Promise<JsonObject> promise = Promise.promise();
        promise.complete(new JsonObject());
        return promise.future();
    }

    @Override
    public Future<JsonArray> findAll() {
        logger.info("Find all");
        Promise<JsonArray> promise = Promise.promise();
        promise.complete(new JsonArray());
        return promise.future();
    }

    @Override
    public Future<JsonObject> save(JsonObject toDo) {
        Promise<JsonObject> promise = Promise.promise();
        return promise.future();
    }

    @Override
    public Future<Void> delete() {
        Promise<Void> promise = Promise.promise();
        return promise.future();
    }
}
