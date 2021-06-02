package com.studies.baseapi.todo.domain.services;


import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface TodoService {
    Future<JsonObject> findOne(Long id);
    Future<JsonArray> findAll();
    Future<JsonObject> save(JsonObject toDo);
    Future<Void> delete();
}
