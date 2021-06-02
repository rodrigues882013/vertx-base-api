package com.studies.baseapi.todo.domain.model;

import io.vertx.core.json.JsonObject;

public class ToDo {

    private String task;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public JsonObject asJsonObject() {
        return JsonObject.mapFrom(this);
    }
}
