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
 * File: EntryPoint.java
 * Class: EntryPoint
 * Qualified: com.atlas.api.v1.resources.graphql.EntryPoint
 *
 * Author: vinas
 * Date: 10/23/16 11:43 PM
 * Modified: 10/23/16 11:43 PM
 */

package com.atlas.api.v1.resources.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

class HelloWorld {

  public static void main(String[] args) {

    GraphQLObjectType queryType = newObject()
      .name("helloWorldQuery")
      .field(newFieldDefinition()
        .type(GraphQLString)
        .name("hello")
        .staticValue("world").build()
      ).build();

    GraphQLSchema schema = GraphQLSchema.newSchema()
      .query(queryType)
      .build();

    Map<String, Object> result = (Map<String, Object>) new GraphQL(schema).execute("{hello}").getData();

    System.out.println(result);
    // Prints: {hello=world}
  }
}
