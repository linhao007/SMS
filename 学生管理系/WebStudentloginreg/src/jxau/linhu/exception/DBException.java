package jxau.linhu.exception;

public class DBException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public DBException(String message)
	{
		super(message);
	}
	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		return super.getStackTrace();
	}
}
