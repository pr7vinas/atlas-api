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
 * File: CreateEntity.java
 * Class: CreateEntity
 * Qualified: com.atlas.api.v1.resources.CreateEntity
 *
 * Author: vinas
 * Date: 10/16/16 1:16 PM
 * Modified: 10/16/16 1:15 PM
 */

package com.atlas.api.v1.resources;

import com.atlas.api.v1.facades.CreateEntityFacade;
import com.atlas.api.v1.models.Entity;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Singleton
@Path("/api/v1/entity")
public class CreateEntity implements AtlasResource {

  private CreateEntityFacade createEntityFacade;

  public CreateEntity() {
    this.createEntityFacade = new CreateEntityFacade();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response execute(Entity entity) {
    check(entity);

    Boolean created = createEntityFacade.execute(entity);

    return buildResponse(created);

  }

  private Response buildResponse(Boolean created) {
    return created
            ? Response.status(Status.CREATED).build()
            : Response.status(Status.INTERNAL_SERVER_ERROR).build();
  }

}