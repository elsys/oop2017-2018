package org.elsys;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) {
		Object p = new Proba(1);
		
		Class<?> clazz = p.getClass();
		
		System.out.println("class name: " + clazz.getName());
		Class<?> sc = clazz.getSuperclass();
		System.out.println("> super class: " + sc.getName());
		
		for(Class<?> i: clazz.getInterfaces()) {
			System.out.println("> interface: " + i.getName());
		}
		
		for(Constructor c: clazz.getDeclaredConstructors()) {
			System.out.println("> cstr name: " + c.getName());
			System.out.println("> cstr params count: " + c.getParameterCount());
		}
		
		for(Field f: clazz.getDeclaredFields()) {
		// for(Field f: clazz.getFields()) {
			System.out.println("> field name: " + f.getName());
			System.out.println("> field type: "+ f.getType().getName());
			System.out.println("> field private: " + 
					Modifier.isPrivate(f.getModifiers()));
		}
		
		for(Method m: clazz.getDeclaredMethods()) {
		// for(Method m: clazz.getMethods()) {
			System.out.println("> method name: " + m.getName());
			System.out.println("> method params count: " + 
					m.getParameterCount());
			System.out.println("> method public: " + 
					Modifier.isPublic(m.getModifiers()));
			for(Class<?> par: m.getParameterTypes()) {
				System.out.println("> par type: " + par.getName());
			}
		}
	}

}
