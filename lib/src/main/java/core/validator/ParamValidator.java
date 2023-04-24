package core.validator;

import core.message.ValidationResult;

public interface ParamValidator {

	String defaultPattern = "[a-zA-Z0-9]{1,}\\.\\D*";

	ValidationResult validate(String fileName);
}
