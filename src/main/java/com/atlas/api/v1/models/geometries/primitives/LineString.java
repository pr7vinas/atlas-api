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
 * File: LineString.java
 * Class: LineString
 * Qualified: com.atlas.api.v1.models.geometries.primitives.LineString
 *
 * Author: vinas
 * Date: 10/16/16 1:33 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.models.geometries.primitives;

import com.atlas.api.v1.models.geometries.Geometry;

import java.util.List;


public class LineString extends Geometry {

  private List<Coordinate> coordinates;

  public LineString() {
    this.type = "LineString";
  }

  public List<Coordinate> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(List<Coordinate> coordinates) {
    this.coordinates = coordinates;
  }

}

