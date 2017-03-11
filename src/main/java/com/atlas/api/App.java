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
 * File: App.java
 * Class: App
 * Qualified: com.atlas.api.App
 *
 * Author: vinas
 * Date: 10/16/16 1:36 PM
 * Modified: 10/16/16 1:35 PM
 */

package com.atlas.api;

import com.atlas.servers.GrizzlyServer;
import org.irenical.lifecycle.builder.CompositeLifeCycle;

public class App {
  public static void main(String[] args) {
    CompositeLifeCycle cycle = new CompositeLifeCycle();
    cycle.append(new GrizzlyServer());
    cycle.start();
  }
}
