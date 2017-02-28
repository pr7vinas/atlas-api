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
 * File: AtlasResource.java
 * Class: AtlasResource
 * Qualified: com.atlas.api.v1.resources.AtlasResource
 *
 * Author: vinas
 * Date: 10/16/16 12:54 PM
 * Modified: 10/16/16 12:54 PM
 */

package com.atlas.api.v1.resources;


import com.atlas.api.v1.models.Entity;
import com.atlas.api.v1.models.GeoJSON;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public interface AtlasResource {

    default void check(Entity entity) {
        checkEntity(entity);
        checkGeoJson(entity.getGeoJSON());
    }

    default void checkEntity(Entity entity) {
        if (entity == null) {
            //// TODO: 16/10/16 log it propertly
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (entity.getIndex() == null || entity.getIndex().trim().isEmpty()) {
            //// TODO: 16/10/16 log it propertly
            throw new WebApplicationException(Response.Status.BAD_REQUEST);

        }
        if (entity.getType() == null || entity.getType().trim().isEmpty()) {
            //// TODO: 16/10/16 log it propertly
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    default void checkGeoJson(GeoJSON geoJSON) {
        if (geoJSON == null) {
            //// TODO: 16/10/16 log it propertly
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (geoJSON.getType() == null || geoJSON.getType().trim().isEmpty()) {
            //// TODO: 16/10/16 log it propertly
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

}