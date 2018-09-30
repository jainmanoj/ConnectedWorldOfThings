package com.worldofthings.model.core.poller;


public class ConditionalCallbackTest {

	public interface ITypedCallback<T> {
		void execute(T type);
	}

	interface CallBack {
		void methodToCallBack();
	}

	static class CallBackImpl<T> implements ITypedCallback<T>, CallBack {
		public void methodToCallBack() {
			System.out.println("I've been called back");
		}

		@Override
		public void execute(T type) {
			System.out.println("I've been called back" + type.getClass().getCanonicalName());

		}
	}

	static public class Caller {
		ITypedCallback<String> callback;

		public Caller(ITypedCallback<String> _callback) {
			this.callback = _callback;
		}

		public void executeCallback() {
			String callbackString = "I am passed by callback";
			callback.execute(callbackString);
		}

	}

	public static void main(String[] args) {
		ITypedCallback<String> icallBack = new CallBackImpl<String>();
		Caller caller = new Caller(icallBack);
		caller.executeCallback();
	}

}
