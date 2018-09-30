package com.worldofthings.model.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;







public class SmartUtility {
	
	
//	
//	public void runIt() {
//	    try {
//	      Class params[] = {};
//	      Object paramsObj[] = {};
//	      Class thisClass = Class.forName(todayClass);
//	      Object iClass = thisClass.newInstance();
//	      Method thisMethod = thisClass.getDeclaredMethod("doit", params);
//	      thisMethod.invoke(iClass, paramsObj);
//	      }
//	    catch (Exception e) {
//	      e.printStackTrace();
//	      }
//	    }
	
	
	public Object getRelationshipThing(IThing thing,String relationName)	throws SmartThingException {
		try {
			 Class<?>[] argTypes = new Class<?>[] {};
			 Method method = ((Class<?>) thing.getClass()).getMethod("get" + relationName,argTypes);
			 return  (Class<?>) method.invoke(thing);
		} catch (Exception ex) {
			throw new SmartThingException(ex);
		}

	}
	
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public Object getProperty(IThing thing,String className,String relationName,String attribute) throws ThingException{
//		//className=BASE_PACKAGE+className;
//		List<Object> propertyObjects = new ArrayList<Object>();
//		try {
//			Object relationShips = getRelationshipThing(thing,relationName);
//			if (relationShips == null || relationShips.isEmpty())
//				return null;
//			for (Object relationOf : relationShips) {
//				String canonicalClassName=getInstanceOfClass(relationOf, className);
//				if (className !=null) {
//					Class cls = Class.forName(canonicalClassName);
//					Object obj = relationOf;
//					Object attibuteObj=getAttribute(cls, obj, attribute);
//					if(attibuteObj instanceof List){
//						propertyObjects.addAll(propertyObjects);
//					} else {
//						propertyObjects.add(attibuteObj);
//					}
//					
//				}
//			}
//			return propertyObjects;
//		} catch (Exception ex) {
//			throw new ThingException(ex);
//		}
//		
//		//return null;
//		
//	}
	
	public Class<?> addRelationShip(IThing fromThing,String relationName, IThing toThing) 	throws SmartThingException {
	try {
		
		 Class<?>[] argTypes = new Class<?>[] { IThing.class };

		Method method = ((Class<?>) fromThing.getClass()).getMethod("add" + relationName,argTypes);


		return  (Class<?>) method.invoke(this,toThing);
	} catch (Exception ex) {
		throw new SmartThingException(ex);
	}
		
	}
	
	public Object getEventAttribute(Class<? extends IThing> cls, Object obj, String eventName)  throws SmartThingException{
		try {
			Method method = cls.getMethod("getInstanceEvent",new Class[]{String.class});
			//Object args=null;
			return method.invoke(obj, eventName);
		} catch (Exception ex) {
			throw new SmartThingException(ex);
		}
	}

}
