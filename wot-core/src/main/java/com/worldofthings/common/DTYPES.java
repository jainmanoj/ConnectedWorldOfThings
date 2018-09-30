package com.worldofthings.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public enum DTYPES {
	BYTE(1, "BYTE", "java.lang.Byte"), 
	SHORT(2, "SHORT", "java.lang.Short"), 
	INTEGER(3, "INTEGER", "java.lang.Integer"), 
	BIGINTEGER(4, "BIGINTEGER","java.math.BigInteger"),
	BIGDECIMAL(5, "BIGDECIMAL", "java.math.BigDecimal"),
	LONG(6, "LONG", "java.lang.Long"), 
	FLOAT(7, "FLOAT", "java.lang.Float"), 
	DOUBLE(8, "DOUBLE","java.lang.Double"), 
	STRING(9, "STRING", "java.lang.String"),
	BOOLEAN(10, "BOOLEAN", "java.lang.Boolean"),
	DATETIME(11, "DATETIME","java.lang.Date"),
	OBJECT(12, "OBJECT", "java.lang.Object");

	Integer id;
	String typeLitral;
	String namespace;
	String value;

	private DTYPES(int id, String typeLitral, String namespace) {
		this.id = id;
		this.typeLitral = typeLitral;
		this.namespace = namespace;
	}
	
          
	public static DTYPES getValueLitral(Object val) {

		//String objectClass=val.getClass().getSimpleName().toUpperCase();

		DTYPES dtype = Enum.valueOf(DTYPES.class, getObjectType(val));
		dtype.setValue(val.toString());
		return dtype;
	}
	



	public String getTypeLitral() {
		return typeLitral;
	}

	public void setLabel(String typeLitral) {
		this.typeLitral = typeLitral;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



	public static Object asType(String type, String string) {

		return null;

	}
	
	
	public static Object asType(DTYPES type, String value) {
		try {
			Class<?> classz = Class.forName(type.getNamespace());
			Object obj = asType(classz, value);
			return obj;
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static boolean isSingleValueType(Class<?> clazz) {
		boolean ret;
		if (isNumber(clazz) || isBoolean(clazz) || isString(clazz)
				|| isEnum(clazz) || isDate(clazz) || isCalendar(clazz)
				|| isCurrency(clazz)) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;

	}

	public static boolean isArrayOrCollection(Class<?> parameterType) {
		return (parameterType.isArray() || Collection.class
				.isAssignableFrom(parameterType));
	}

	public static boolean isNumber(Class<?> clazz) {
		return (Number.class.isAssignableFrom(clazz) || int.class == clazz
				|| long.class == clazz || float.class == clazz
				|| byte.class == clazz || short.class == clazz || double.class == clazz);
	}

	public static boolean isInteger(Class<?> clazz) {
		return (Integer.class.isAssignableFrom(clazz) || int.class == clazz);
	}

	public static boolean isLong(Class<?> clazz) {
		return (Long.class.isAssignableFrom(clazz) || long.class == clazz);
	}

	public static boolean isFloat(Class<?> clazz) {
		return (Float.class.isAssignableFrom(clazz) || float.class == clazz);
	}

	public static boolean isDouble(Class<?> clazz) {
		return (Double.class.isAssignableFrom(clazz) || double.class == clazz);
	}

	public static boolean isByte(Class<?> clazz) {
		return (Byte.class.isAssignableFrom(clazz) || byte.class == clazz);
	}

	public static boolean isShort(Class<?> clazz) {
		return (Short.class.isAssignableFrom(clazz) || short.class == clazz);
	}

	public static boolean isBoolean(Class<?> clazz) {
		return (Boolean.class.isAssignableFrom(clazz) || boolean.class == clazz);
	}

	public static boolean isEnum(Class<?> clazz) {
		return Enum.class.isAssignableFrom(clazz);
	}

	public static boolean isString(Class<?> parameterType) {
		return String.class.isAssignableFrom(parameterType);
	}

	public static boolean isBigInteger(Class<?> clazz) {
		return BigInteger.class.isAssignableFrom(clazz);
	}

	public static boolean isBigDecimal(Class<?> clazz) {
		return BigDecimal.class.isAssignableFrom(clazz);
	}

	public static boolean isDate(Class<?> clazz) {
		return Date.class.isAssignableFrom(clazz);
	}

	public static boolean isCalendar(Class<?> clazz) {
		return Calendar.class.isAssignableFrom(clazz);
	}

	public static boolean isCurrency(Class<?> clazz) {
		return Currency.class.isAssignableFrom(clazz);
	}

	private static String getObjectType(Object val) {
		Class<?> classz = val.getClass();
		if (isBoolean(classz)) {
			return DTYPES.BOOLEAN.name();
		} else if (isInteger(classz)) {
			return DTYPES.INTEGER.name();
		} else if (isLong(classz)) {
			return DTYPES.LONG.name();
		} else if (isDouble(classz)) {
			return DTYPES.DOUBLE.name();
		} else if (isFloat(classz)) {
			return DTYPES.FLOAT.name();
		} else if (isByte(classz)) {
			return DTYPES.BYTE.name();
		} else if (isShort(classz)) {
			return DTYPES.SHORT.name();
		} else if (isBigInteger(classz)) {
			return DTYPES.BIGINTEGER.name();
		} else if (isBigDecimal(classz)) {
			return DTYPES.BIGDECIMAL.name();
		} else if (isString(classz)) {
			return DTYPES.STRING.name();
		} else {
			return DTYPES.OBJECT.name();
		}
	}
	
	public static Object asType(Class<?> type, String string) {
		if (isBoolean(type)) {
			return Boolean.parseBoolean(string);
		} else if (isInteger(type)) {
			return Integer.parseInt(string);
		} else if (isLong(type)) {
			return Long.parseLong(string);
		} else if (isDouble(type)) {
			return Double.parseDouble(string);
		} else if (isFloat(type)) {
			return Float.parseFloat(string);
		} else if (isByte(type)) {
			return Byte.parseByte(string);
		} else if (isShort(type)) {
			return Short.parseShort(string);
		} else if (isBigInteger(type)) {
			return new BigInteger(string);
		} else if (isBigDecimal(type)) {
			return new BigDecimal(string);
		} else if (isCalendar(type)) {
			return DatatypeConverter.parseDateTime(string);
		} else if (isDate(type)) {
			if (isIsoLatin1Number(string)) {
				return new Date(Long.parseLong(string));
			} else {
				return DatatypeConverter.parseDateTime(string).getTime();
			}
		} else if (isCurrency(type)) {
			return Currency.getInstance(string);
		} else if (type.isEnum()) {
			return Enum.valueOf((Class<? extends Enum>) type, string);
		} else {
			return string;
		}
	}

	public static boolean isIsoLatin1Number(String str) {
		if (str == null)
			return false;
		char[] data = str.toCharArray();
		if (data.length == 0)
			return false;
		int index = 0;
		if (data.length > 1 && (data[0] == '-' || data[0] == '+'))
			index = 1;
		for (; index < data.length; index++) {
			if (data[index] < '0' || data[index] > '9')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		Object mybool=DTYPES.asType(Enum.valueOf(DTYPES.class, "BOOLEAN"),"true");
		
		System.out.println("DATA is "+mybool.getClass().getCanonicalName() + "  VALUE "+mybool);
		
		Object myInt=DTYPES.asType(Enum.valueOf(DTYPES.class, "INTEGER"),"1000");
		
		System.out.println("DATA is "+myInt.getClass().getCanonicalName() + "  VALUE "+myInt);
		

	}

};
