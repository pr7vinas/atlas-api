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
 * File: Feature.java
 * Class: Feature
 * Qualified: com.atlas.api.v1.models.feature.Feature
 *
 * Author: vinas
 * Date: 10/16/16 1:31 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.models.feature;

import com.atlas.api.v1.models.GeoJSON;
import com.atlas.api.v1.models.geometries.Geometry;

import java.util.Map;

public class Feature extends GeoJSON {

    private Geometry geometry;
    private Map<String, Object> properties;

    public Feature() {
        this.type = "Feature";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
