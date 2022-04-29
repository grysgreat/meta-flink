/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.metaflink.database.config;

import com.example.metaflink.database.enums.FilterEnum;
import com.example.metaflink.database.enums.OperationEnum;

import java.io.Serializable;

/**
 * @author binghe
 * @version 1.0.0
 * @description 字段属性条件
 */
public class Filter implements Serializable {
    private static final long serialVersionUID = -914368803651884302L;

    /**
     * 字段名，ID
     */
    private String name;
    /**
     * @see OperationEnum
     */
    private String operation;

    /**
     * @see FilterEnum
     */
    private String filter;

    /**
     * 值
     */
    private String value;

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public String getFilter() {
        return filter;
    }

    public String getValue() {
        return value;
    }
}
