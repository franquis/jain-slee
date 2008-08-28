package org.mobicents.slee.container.management.jmx;

import org.jboss.system.ServiceMBean;

public interface MobicentsManagementMBean extends ServiceMBean {
  
  public double getEntitiesRemovalDelay();
  public void setEntitiesRemovalDelay(double entitiesRemovalDelay);
  
  /**
	 * 
	 * @return string representation of container's version.
	 */
	public String getVersion();

}
