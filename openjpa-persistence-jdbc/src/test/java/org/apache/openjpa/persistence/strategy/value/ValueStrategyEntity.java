/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.openjpa.persistence.strategy.value;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.openjpa.persistence.jdbc.Strategy;

@Entity
public class ValueStrategyEntity {
    @Id
    @Strategy ("org.apache.openjpa.persistence.strategy.value.ValueStrategyHandler")
    private String id;
    
    @Strategy ("org.apache.openjpa.persistence.strategy.value.ValueStrategyHandler")
    private String name;

    /**
     * This field gets AUTOMATICALLY converted by OpenJPA because we registered
     * the {@link PrincipalValueStrategyHandler} in persistence.xml.
     * Currently this needs either to be Serializable, so we cannot store Principal but only the impl :(
     */
    @Strategy("org.apache.openjpa.persistence.strategy.value.PrincipalValueStrategyHandler")
    private PrincipalValueStrategyHandler.TestPrincipal user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrincipalValueStrategyHandler.TestPrincipal getUser() {
        return user;
    }

    public void setUser(PrincipalValueStrategyHandler.TestPrincipal user) {
        this.user = user;
    }
}
