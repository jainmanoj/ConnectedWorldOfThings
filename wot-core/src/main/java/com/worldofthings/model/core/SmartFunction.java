package com.worldofthings.model.core;

import java.util.List;
import java.util.function.Function;

import com.worldofthings.common.DTYPES;
import com.worldofthings.common.SUMMARIZEDBYFUNC;

public class SmartFunction {

	public static Function<List<IEvent>, IEvent> Aggregate;

	public static ValueType FUNCTIONS(List<ValueType> valueTypes, SUMMARIZEDBYFUNC func) {

		if(func.equals(SUMMARIZEDBYFUNC.AVARAGE)){
			Class<?> classz= valueTypes.get(0).getValueObj().getClass();
			ValueType avg=getAverage(valueTypes, classz);
			return avg;
		}
		

		return null;

	}


	public static ValueType getSum(List<ValueType> values, Class<?> classz) {
		if (DTYPES.isInteger(classz)) {
			Integer sum = 0;
			for (ValueType value : values) {
				sum += (Integer) value.getValueObj();
				return new ValueType(sum);
			}
		} else if (DTYPES.isDouble(classz)) {
			Double sum = 0.0;
			for (ValueType value : values) {
				sum += (Double) value.getValueObj();
				return new ValueType(sum);
			}
		}
		return null;

	}

	public static ValueType getAverage(List<ValueType> values, Class<?> classz) {
		if (DTYPES.isInteger(classz)) {
			Integer sum = 0;
			for (ValueType value : values) {
				sum += (Integer) value.getValueObj();
				return new ValueType(sum / values.size());
			}
		} else if (DTYPES.isDouble(classz)) {
			Double sum = 0.0;
			for (ValueType value : values) {
				sum += (Double) value.getValueObj();
				return new ValueType(sum / values.size());
			}
		}
		return null;
	}
	
	
	

	
	public static ValueType getMax(List<ValueType> values, Class<?> classz) {
		
		if (DTYPES.isInteger(classz)) {
			Integer max = (Integer) values.get(0).getValueObj();
			for (ValueType value : values) {
			       if((Integer) value.getValueObj() > max){
			            max = (Integer)value.getValueObj();
			         }
				return new ValueType(max);
			}
		} else if (DTYPES.isDouble(classz)) {
			Double max = (Double) values.get(0).getValueObj();
			for (ValueType value : values) {
			       if((Double) value.getValueObj() > max){
			            max = (Double)value.getValueObj();
			         }
				return new ValueType(max);
			}
		}
		return null;
   }

	
	public static ValueType getMin(List<ValueType> values, Class<?> classz) {
		
		if (DTYPES.isInteger(classz)) {
			Integer min = (Integer) values.get(0).getValueObj();
			for (ValueType value : values) {
			       if((Integer) value.getValueObj() < min){
			            min = (Integer)value.getValueObj();
			         }
				return new ValueType(min);
			}
		} else if (DTYPES.isDouble(classz)) {
			Double min = (Double) values.get(0).getValueObj();
			for (ValueType value : values) {
			       if((Double) value.getValueObj() < min){
			            min = (Double)value.getValueObj();
			         }
				return new ValueType(min);
			}
		}
		return null;
   }

}
