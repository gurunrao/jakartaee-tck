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
 * @(#)SecTestRoleRefEJB.java	1.8 03/05/16
 */

// The purpose of this EJB is to test scoping of security role references.

package com.sun.ts.tests.ejb.ee.sec.stateful.common;

import com.sun.ts.lib.util.RemoteLoggingInitException;
import com.sun.ts.lib.util.TestUtil;

import jakarta.ejb.CreateException;
import jakarta.ejb.EJBException;
import jakarta.ejb.SessionBean;
import jakarta.ejb.SessionContext;

public class SecTestRoleRefEJB implements SessionBean {

  private SessionContext sctx = null;

  public void ejbCreate(java.util.Properties p) throws CreateException {
    try {
      TestUtil.init(p);
    } catch (RemoteLoggingInitException e) {
      TestUtil.printStackTrace(e);
      TestUtil.logMsg("SecTestRoleRefEJB initLogging failed.");
      throw new EJBException(e.getMessage());
    }
  }

  public boolean EjbSecRoleRefScope(String role) {
    return sctx.isCallerInRole(role);
  }

  public void setSessionContext(SessionContext sc) {
    sctx = sc;
  }

  public void ejbRemove() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

}
