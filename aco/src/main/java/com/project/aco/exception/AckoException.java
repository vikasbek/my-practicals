package com.project.aco.exception;

public class AckoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg;

	public AckoException() {
		super();
	}

	public AckoException(String code, String msg) {
		super(code.concat(msg));
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AckoException [code=" + code + ", msg=" + msg + "]";
	}
}
