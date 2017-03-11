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
 * File: CreateEntityFacade.java
 * Class: CreateEntityFacade
 * Qualified: com.atlas.api.v1.facades.CreateEntityFacade
 *
 * Author: vinas
 * Date: 10/16/16 9:43 PM
 * Modified: 10/16/16 9:41 PM
 */

package com.atlas.api.v1.facades;

import com.atlas.api.v1.exceptions.ClientInitializationException;
import com.atlas.api.v1.models.Entity;
import com.atlas.api.v1.queries.CreateGeoJsonQuery;

public class CreateEntityFacade implements AtlasFacade<Entity, Boolean> {

    private final CreateGeoJsonQuery query;

    public CreateEntityFacade() {
        this.query = new CreateGeoJsonQuery();
    }

    @Override
    public Boolean execute(final Entity entity) throws ClientInitializationException {
        return query.run(entity);
    }

}