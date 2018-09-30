package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.ValueType;

public interface ICallback {
	<T> void execute(ValueType<T> type, Boolean isActive);
}
