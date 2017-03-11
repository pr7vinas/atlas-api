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
 * File: Entity.java
 * Class: Entity
 * Qualified: com.atlas.api.v1.models.Entity
 *
 * Author: vinas
 * Date: 10/16/16 1:12 PM
 * Modified: 10/16/16 1:12 PM
 */

package com.atlas.api.v1.models;

public class Entity {

  private String index;
  private String type;
  private GeoJSON geoJSON;

  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeoJSON getGeoJSON() {
    return geoJSON;
  }

  public void setGeoJSON(GeoJSON geoJSON) {
    this.geoJSON = geoJSON;
  }

}
