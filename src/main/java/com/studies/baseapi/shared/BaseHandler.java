package com.studies.baseapi.shared;

import io.vertx.ext.web.RoutingContext;

public interface BaseHandler {
    void get(RoutingContext ctx);
    void post(RoutingContext ctx);
    void put(RoutingContext ctx);
    void delete(RoutingContext ctx);
}
