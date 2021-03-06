/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * @(#)SimpleEndpointImpl.java	1.2	04/11/17
 */

package com.sun.ts.tests.jaxws.wsi.w2j.rpc.literal.R2113;

import com.sun.javatest.util.StringArray;
import com.sun.ts.tests.jaxws.sharedwebservices.simpleservice.SimpleEndpoint;

import jakarta.jws.WebService;

@WebService(portName = "SimpleEndpointPort", serviceName = "SimpleTest", targetNamespace = "http://simpletestservice.org/wsdl", wsdlLocation = "WEB-INF/wsdl/W2JRLR2113TestService.wsdl", endpointInterface = "com.sun.ts.tests.jaxws.wsi.w2j.rpc.literal.R2113.SimpleEndpoint")

public class SimpleEndpointImpl implements SimpleEndpoint {
  public String helloWorld() {
    return "hello world";
  }

  public StringArray arrayOperation() {
    StringArray sa = new StringArray();
    sa.getString().add("one");
    sa.getString().add("two");
    sa.getString().add("three");
    return sa;
  }

  public String arrayOperationFromClient(StringArray array) {
    return "success";
  }
}
