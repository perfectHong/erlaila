package cn.erlaila.mybatis.exception;

public class CustomException extends Exception {
	//“Ï≥£–≈œ¢
	public String  exceptionMessage;
	
	public CustomException(String exceptionMessage){
		 super(exceptionMessage);
		 this.exceptionMessage=exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
}
