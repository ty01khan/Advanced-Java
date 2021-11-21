package com.helper;

import org.hibernate.Session;

public class SessionProvider {
	public static Session getSession() {
		return FactoryProvider.getFactory().openSession();
	}
}
