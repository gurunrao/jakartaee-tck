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
 * $Id$
 */

package com.sun.ts.tests.jaxws.api.jakarta_xml_ws.AsyncHandler;

import com.sun.ts.lib.util.*;

import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.Response;
import javax.xml.transform.Source;

public class XMLAsyncHandler implements AsyncHandler<Source> {
  private boolean dataReady = false;

  private Source theData;

  private java.util.Map<String, Object> theContext;

  public XMLAsyncHandler() {
    TestUtil.logMsg("in XMLAsyncHandler");
  }

  public synchronized boolean isDataReady() {
    return dataReady;
  }

  public Source getData() {
    return theData;
  }

  public java.util.Map<String, Object> getContext() {
    return theContext;
  }

  public void handleResponse(Response<Source> res) {
    TestUtil.logMsg("in XMLAsyncHandler.handleResponse()");
    try {
      theData = res.get();
      theContext = res.getContext();
    } catch (Exception e) {
      e.printStackTrace();
    }
    synchronized (this) {
      dataReady = true;
    }
  }
}
