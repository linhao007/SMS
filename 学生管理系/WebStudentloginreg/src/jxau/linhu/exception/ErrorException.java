package jxau.linhu.exception;

public class ErrorException extends RuntimeException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public ErrorException(String message)
	{
		super(message);
	}
	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		return super.getStackTrace();
	}

	
}
