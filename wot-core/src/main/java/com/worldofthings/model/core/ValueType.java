package com.worldofthings.model.core;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldofthings.common.DTYPES;


public class ValueType<T> implements Comparator<ValueType<T>> {	
	
	@Expose @SerializedName("type")
	final String type;
	@Expose @SerializedName("value")
	final String value;
	@Expose @SerializedName("valueObj")
	//final Object valueObj;
	final T valueObj;
	
	
	@SuppressWarnings("unchecked")
	public ValueType(String type, String value) {
		DTYPES dtype=Enum.valueOf(DTYPES.class, type);
		this.type = dtype.getTypeLitral();
		this.value = value;
		this.valueObj = (T) DTYPES.asType(dtype,value);;
	}

    
    public ValueType(T typedValueObj) {
    	DTYPES dtype = DTYPES.getValueLitral(typedValueObj.getClass());
    	this.type = dtype.getTypeLitral();
    	this.value = dtype.getValue();
    	this.valueObj=typedValueObj;
    }
	
	
    public Object getValueObj(){
		return valueObj;
	}
	
	public T get(Class<T> clazz) {
		//if(clazz.getCanonicalName().equals(DTYPES.valueOf(type).getNamespace()))
			return clazz.cast(valueObj);
		//else 
			//return null;
    }

	public String getType() {
		return type;
		
	}

	@Override
	public int compare(ValueType<T> vt1, ValueType<T> vt2) {
		if (vt1.getType().equals(vt2.getType())) {
			DTYPES dtype = Enum.valueOf(DTYPES.class, vt1.getType().toUpperCase());
			//System.out.println("DTYPES.INTEGER.name() DTYPES is "+dtype);
			switch (dtype) {
			case BYTE:
				return ((Byte) vt1.getValueObj()).compareTo(((Byte) vt2.getValueObj()));
			case SHORT:
				return ((Short) vt1.getValueObj()).compareTo(((Short) vt2.getValueObj()));
			case INTEGER:
				return ((Integer) vt1.getValueObj()).compareTo(((Integer) vt2.getValueObj()));
			case BIGINTEGER:
				return ((BigInteger) vt1.getValueObj()).compareTo(((BigInteger) vt2.getValueObj()));
			case BIGDECIMAL:
				return ((BigDecimal) vt1.getValueObj()).compareTo(((BigDecimal) vt2.getValueObj()));
			case LONG:
				return ((Long) vt1.getValueObj()).compareTo(((Long) vt2.getValueObj()));
			case FLOAT:
				return ((Float) vt1.getValueObj()).compareTo(((Float) vt2.getValueObj()));
			case DOUBLE:
				return ((Double) vt1.getValueObj()).compareTo(((Double) vt2.getValueObj()));
			case STRING:
				return ((String) vt1.getValueObj()).compareTo(((String) vt2.getValueObj()));
			case BOOLEAN:
				return ((Boolean) vt1.getValueObj()).compareTo(((Boolean) vt2.getValueObj()));
			case DATETIME:
				// return ((Date) vt1.getValueObj()).compareTo(((Date) vt2.getValueObj()));
			case OBJECT:
				// return ((Object) vt1.getValueObj()).compareTo(((Object) vt2.getValueObj()));
			default:
				break;
			}

		}
		return -1;

	}
	
	public boolean equalTo(ValueType<T> vtc) {
		if(compare(this, vtc) ==0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean greaterThanEqualTo(ValueType<T> vtc) {
		if(compare(this, vtc) >=0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean lessThanEqualTo(ValueType<T> vtc) {
		if(compare(this, vtc) <=0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean compareTo(ValueType<T> vtc) {
		if(compare(this, vtc) >=0) {
			return true;
		} else {
			return false;
		}
	}




	@Override
	public String toString() {
		return type+"::"+value+"::"+valueObj;
	}

	
	public static void main(String[] args) throws ClassNotFoundException {
		ValueType<?> vt1 = new ValueType<Long>(DTYPES.LONG.getTypeLitral(),"100000000000000000"); System.out.println("VT "+vt1+"\n");
		ValueType<?> vt2 = new ValueType<Double>(10.05); System.out.println("VT "+vt2+"\n");
		ValueType<?> vt3 = new ValueType<String>("Manoj"); System.out.println("VT "+vt3+"\n");
		
		
		
		
	}





}
