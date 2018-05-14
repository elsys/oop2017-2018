package org.elsys;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActive {

	public static void main(String[] args)  {
		try {
			Class<?> clazz = Class.forName("org.elsys.Proba");
			System.out.println("> class name: " + clazz.getName());
			Object p = clazz.newInstance();
			System.out.println("> object class: " +
					p.getClass().getName());
			Method m = clazz.getDeclaredMethod("getVal");
			Object res = m.invoke(p);
			System.out.println("> method result: " + res);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
