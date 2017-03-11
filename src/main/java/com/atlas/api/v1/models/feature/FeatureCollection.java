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
 * File: FeatureCollection.java
 * Class: FeatureCollection
 * Qualified: com.atlas.api.v1.models.feature.FeatureCollection
 *
 * Author: vinas
 * Date: 10/16/16 1:31 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.models.feature;

import com.atlas.api.v1.models.GeoJSON;

import java.util.List;


public class FeatureCollection extends GeoJSON {


  private List<Feature> features;

  public FeatureCollection() {
    this.type = "FeatureCollection";
  }

  public List<Feature> getFeatures() {
    return features;
  }

  public void setFeatures(List<Feature> features) {
    this.features = features;
  }
}
