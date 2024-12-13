package io.arrogantprogrammer.christmashannukah.rest;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.event.Observes;


public class StaticResources {

    void installRoute(@Observes StartupEvent startupEvent, Router router) {
        router.route()
                .method(HttpMethod.GET)
                .path("/static/*")
                .handler(StaticHandler.create("static/"));
    }
}
