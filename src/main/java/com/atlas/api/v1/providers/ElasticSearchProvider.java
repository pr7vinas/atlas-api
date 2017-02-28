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
 * File: ElasticSearchProvider.java
 * Class: ElasticSearchProvider
 * Qualified: com.atlas.api.v1.providers.ElasticSearchProvider
 *
 * Author: vinas
 * Date: 10/16/16 1:34 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.providers;

import com.atlas.api.v1.exceptions.ClientInitializationException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticSearchProvider implements AtlasProvider<TransportClient> {

    private static final String ATLAS_CLUSTER = "atlas_cluster";
    private static final String CLUSTER_NAME = "cluster.name";

    private final String host;
    private final int port;
    private final Settings settings;

    public ElasticSearchProvider() {
        settings = Settings.settingsBuilder().put(CLUSTER_NAME, ATLAS_CLUSTER).build();
        host = "localhost";
        port = 9200;
    }

    @Override
    public TransportClient getClient() throws ClientInitializationException {
        try {
            return TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            throw new ClientInitializationException(e);
        }
    }

}