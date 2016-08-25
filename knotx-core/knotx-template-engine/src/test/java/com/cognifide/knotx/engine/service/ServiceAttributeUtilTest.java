/*
 * Knot.x - Reactive microservice assembler - Templating Engine Verticle
 *
 * Copyright (C) 2016 Cognifide Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognifide.knotx.engine.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


/**
 * @author pawel.koper on 25.08.16.
 */
public class ServiceAttributeUtilTest {
    @Test
    public void testAttributeWithoutNamespace() throws Exception {
        String attributeInput = "data-call-uri";
        String namespace = ServiceAttributeUtil.extractNamespace(attributeInput);
        Assert.assertThat(namespace, is(StringUtils.EMPTY));
    }

    @Test
    public void testAttributeWithNamespace() throws Exception {
        String attributeInput = "data-call-uri-label";
        String namespace = ServiceAttributeUtil.extractNamespace(attributeInput);
        Assert.assertThat(namespace, is("label"));
    }

    @Test
    public void testAttributeWithTwoNamespaces() throws Exception {
        String attributeInput = "data-call-uri-message-label";
        String namespace = ServiceAttributeUtil.extractNamespace(attributeInput);
        Assert.assertThat(namespace, is(StringUtils.EMPTY));
    }

    @Test
    public void testAttributeWithBrokenNamespace() throws Exception {
        String attributeInput = "data-call-uri--label";
        String namespace = ServiceAttributeUtil.extractNamespace(attributeInput);
        Assert.assertThat(namespace, is(StringUtils.EMPTY));
    }

}