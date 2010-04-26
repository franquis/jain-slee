package org.mobicents.slee.runtime.activity;

import org.apache.log4j.Logger;
import org.mobicents.slee.container.SleeContainer;
import org.mobicents.slee.container.activity.ActivityContextHandle;
import org.mobicents.slee.container.transaction.SleeTransactionManager;

public class UnreferencedActivity2ndCheckTask implements Runnable {

	private static final Logger logger = Logger
			.getLogger(UnreferencedActivity2ndCheckTask.class);
	private static final SleeContainer sleeContainer = SleeContainer
			.lookupFromJndi();

	private final ActivityContextHandle ach;
	private final ActivityContextFactoryImpl factory;
	
	UnreferencedActivity2ndCheckTask(ActivityContextImpl ac) {
		this.ach = ac.getActivityContextHandle();
		this.factory = ac.getFactory();
	}

	public void run() {

		SleeTransactionManager txManager = sleeContainer
				.getTransactionManager();
		boolean rollback = true;
		try {
			txManager.begin();
			ActivityContextImpl ac = factory.getActivityContext(ach);
			if (ac != null && !ac.isEnding()) {
				ac.unreferencedActivity2ndCheck();
			}
			rollback = false;
		} catch (Exception e) {
			logger.error(
					"failure while running unrefered activity 2nd check for ac with id "
							+ ach, e);
		} finally {
			try {
				if (rollback) {
					txManager.rollback();
				} else {
					txManager.commit();
				}
			} catch (Exception e) {
				logger
						.error(
								"failure while ending tx, while running unrefered activity 2nd check for ac with id "
										+ ach, e);
			}
		}
	}
}
