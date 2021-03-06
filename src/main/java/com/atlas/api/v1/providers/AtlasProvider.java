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
 * File: AtlasProvider.java
 * Class: AtlasProvider
 * Qualified: com.atlas.api.v1.providers.AtlasProvider
 *
 * Author: vinas
 * Date: 10/16/16 1:34 PM
 * Modified: 10/16/16 12:32 PM
 */

package com.atlas.api.v1.providers;


import com.google.gson.Gson;


public interface AtlasProvider {

  default String toJson(Object o) {
    Gson gson = new Gson();
    return gson.toJson(o);
  }

}
