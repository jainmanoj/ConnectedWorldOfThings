package com.worldofthings.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

final class InterfaceSerializer<T> implements JsonSerializer<T>,JsonDeserializer<T> {

	private final Class<T> implementationClass;

	private InterfaceSerializer(final Class<T> implementationClass) {
		this.implementationClass = implementationClass;
	}

	static <T> InterfaceSerializer<T> interfaceSerializer(final Class<T> implementationClass) {
		return new InterfaceSerializer<>(implementationClass);
	}

	@Override
	public JsonElement serialize(final T value, final Type type, final JsonSerializationContext context) {
		final Type targetType = value != null ? value.getClass() : type; 
		return context.serialize(value, targetType);
	}

	@Override
	public T deserialize(JsonElement json, Type typeOfT,JsonDeserializationContext context) throws JsonParseException {
		return context.deserialize(json, implementationClass);
	}

}