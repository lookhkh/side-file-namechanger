package core.message;

import core.common.MessageInterface;

public class ValidationResult implements MessageInterface {
	
	private boolean isValid;
	private String fileName;
	
	public ValidationResult(String fileName, boolean result) {
		this.isValid = result;
		this.fileName = fileName;
	}

	public boolean isResult() {
		return this.isValid;
	}

	public String getFileName() {
		return this.fileName;
	}

}
