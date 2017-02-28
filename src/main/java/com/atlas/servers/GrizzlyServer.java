/*
 * Copyright 2016 Atlas, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 *
 * Module: atlas
 * File: GrizzlyServer.java
 * Class: GrizzlyServer
 * Qualified: com.atlas.servers.GrizzlyServer
 *
 * Author: vinas
 * Date: 10/16/16 9:46 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.servers;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.irenical.lifecycle.LifeCycle;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final public class GrizzlyServer implements LifeCycle {

    private static ExecutorService threadPool = Executors.newCachedThreadPool();
    private HttpServer server;

    private static ExecutorService getThreadPool() {
        if (threadPool == null || threadPool.isShutdown()) {
            threadPool = Executors.newCachedThreadPool(toRun -> new Thread(toRun, "ATLAS-ASYNC-TASK"));
        }
        return threadPool;
    }

    @Override
    public void start() throws Exception {
        Properties prop = loadProperties();

        URI baseUri = UriBuilder
                .fromUri((String) prop.get("server.base.uri"))
                .port(Integer.valueOf((String) prop.get("server.base.port")))
                .path((String) prop.get("server.base.path"))
                .build();


        ResourceConfig configuration = new ResourceConfig();
        configuration.packages("com.atlas.api.v1.resources");
        configuration.register(JacksonFeature.class);
        server = GrizzlyHttpServerFactory.createHttpServer(baseUri, configuration);
    }

    private Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);
        return prop;
    }

    @Override
    public void stop() {
        getThreadPool().shutdown();
        server.shutdown();
    }

    @Override
    public boolean isRunning() {
        return server.isStarted();
    }

}