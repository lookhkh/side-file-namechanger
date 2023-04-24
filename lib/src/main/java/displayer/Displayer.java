package displayer;

import core.message.ValidationResult;

public interface Displayer {

	void input(String fileName);

	String getFileName();
	
	ValidationResult showResult(ValidationResult res);

}
