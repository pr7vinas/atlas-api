package com.atlas.api.v1.providers.elasticsearch;

import com.atlas.api.v1.exceptions.ClientInitializationException;
import com.atlas.api.v1.providers.AtlasProvider;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.function.Function;

/**
 * Copyright 2017 Atlas, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 * <p>
 * File: ElasticSearch
 * Author: Vinicius Alvarenga
 * Contact: pr7vinas@gmail.com
 * Date: 11/03/2017
 * Time: 13:18
 **/
public enum ElasticSearch implements AtlasProvider {
    INSTANCE;

    private static final String ATLAS_CLUSTER = "atlas_cluster";
    private static final String CLUSTER_NAME = "cluster.name";

    private final String host;
    private final int port;
    private final Settings settings;
    private TransportClient client = null;

    ElasticSearch() {
        settings = Settings.builder().put(CLUSTER_NAME, ATLAS_CLUSTER).build();
        host = "localhost";
        port = 9200;
    }

    private TransportClient getClient() throws ClientInitializationException {
        try {
            if (client == null) {
                client = new PreBuiltTransportClient(settings);
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            }
            return client;
        } catch (UnknownHostException e) {
            throw new ClientInitializationException(e);
        }
    }

    public <INPUT extends Function<TransportClient, OUTPUT>, OUTPUT> OUTPUT execute(INPUT input)
    throws ClientInitializationException {
        try {
            return input.apply(this.getClient());
        } finally {
            this.getClient().close();
        }

    }
}
