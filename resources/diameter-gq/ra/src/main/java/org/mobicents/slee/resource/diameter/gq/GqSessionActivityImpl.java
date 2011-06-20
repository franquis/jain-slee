/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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

package org.mobicents.slee.resource.diameter.gq;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.DiameterMessageFactory;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.gq.GqMessageFactory;
import net.java.slee.resource.diameter.gq.GqSessionActivity;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.Session;
import org.mobicents.slee.resource.diameter.base.DiameterActivityImpl;


/**
 * 
 * @author <a href="mailto:webdev@web-ukraine.info"> Yulian Oifa </a>
 */
public abstract class GqSessionActivityImpl extends DiameterActivityImpl implements GqSessionActivity {

  private static final long serialVersionUID = 1L;

  protected GqMessageFactory gqMessageFactory;

  /**
   * @param messageFactory
   * @param avpFactory
   * @param session
   * @param raEventListener
   * @param destinationHost
   * @param destinationRealm
   */
  public GqSessionActivityImpl(DiameterMessageFactory messageFactory, DiameterAvpFactory avpFactory, Session session,
      EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm) {
    super(messageFactory, avpFactory, session, raEventListener, destinationHost, destinationRealm);
  }

  @Override
  public GqMessageFactory getGqMessageFactory() {
    return this.gqMessageFactory;
  }

  public void setGqMessageFactory(GqMessageFactory gqMessageFactory) {
    this.gqMessageFactory = gqMessageFactory;
  }

  public void setDestinationHost(DiameterIdentity destinationHost) {
    super.destinationHost = destinationHost;
  }

  public void setDestinationRealm(DiameterIdentity destinationRealm) {
    super.destinationRealm = destinationRealm;
  }
}