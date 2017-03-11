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
 * File: CreateGeoJsonQuery.java
 * Class: CreateGeoJsonQuery
 * Qualified: com.atlas.api.v1.queries.CreateGeoJsonQuery
 *
 * Author: vinas
 * Date: 10/16/16 1:34 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.queries;


import com.atlas.api.v1.exceptions.ClientInitializationException;
import com.atlas.api.v1.models.Entity;
import com.atlas.api.v1.providers.elasticsearch.ElasticSearch;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.rest.RestStatus;

import java.util.UUID;


public class CreateGeoJsonQuery {

  public boolean run(final Entity entity) throws ClientInitializationException {
    IndexResponse indexResponse = ElasticSearch.INSTANCE.execute(client -> client.prepareIndex(
      entity.getIndex(),
      entity.getType(),
      UUID.randomUUID().toString()).setSource(ElasticSearch.INSTANCE.toJson(entity)).get());

    return indexResponse.status().compareTo(RestStatus.CREATED) == 0;
  }

}
