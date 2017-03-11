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
 * File: GeometryCollection.java
 * Class: GeometryCollection
 * Qualified: com.atlas.api.v1.models.geometries.GeometryCollection
 *
 * Author: vinas
 * Date: 10/16/16 1:33 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.models.geometries;

import com.atlas.api.v1.models.GeoJSON;

import java.util.List;


public class GeometryCollection extends GeoJSON {

  private List<Geometry> geometries;

  public GeometryCollection() {
    this.type = "GeometryCollection";
  }

  public String getType() {
    return type;
  }

  public List<Geometry> getGeometries() {
    return geometries;
  }

  public void setGeometries(List<Geometry> geometries) {
    this.geometries = geometries;
  }

}
