/*
* JBoss, Home of Professional Open Source.
* Copyright 2011, Red Hat Middleware LLC, and individual contributors
* as indicated by the @author tags. See the copyright.txt file in the
* distribution for a full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.as.j2eemanagement.subsystem;

import static org.jboss.as.j2eemanagement.subsystem.Constants.JNDI_NAME;

import org.jboss.as.controller.AbstractRemoveStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.naming.deployment.ContextNames;
import org.jboss.dmr.ModelNode;

/**
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
class J2EEManagementSubsystemRemove extends AbstractRemoveStepHandler {

    static J2EEManagementSubsystemRemove INSTANCE = new J2EEManagementSubsystemRemove();

    private J2EEManagementSubsystemRemove() {
    }

    @Override
    protected void performRuntime(OperationContext context, ModelNode operation, ModelNode model) throws OperationFailedException {
        context.removeService(RegisterMBeanServerDelegateService.SERVICE_NAME);
        context.removeService(RegisterManagementEJBService.SERVICE_NAME);
        context.removeService(TempMBeanService.SERVICE_NAME);
        context.removeService(ContextNames.bindInfoFor(JNDI_NAME).getBinderServiceName());
    }



}
