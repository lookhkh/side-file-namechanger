package core.validator;

import core.message.ValidationResult;

public class SimpleParamValidator implements ParamValidator {

	private String pattern;
	
	public SimpleParamValidator(String pattern) {
		this.pattern = pattern;
	
	}

	public SimpleParamValidator() {
		this.pattern = ParamValidator.defaultPattern;
	}

	@Override
	public ValidationResult validate(String fileName) {
		
		boolean isValidFileName = fileName.matches(this.pattern);
		
		
		return new ValidationResult(fileName,isValidFileName);
	}

}
