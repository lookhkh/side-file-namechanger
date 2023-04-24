package displayer;

import core.message.ValidationResult;

public class SimpleDisplayer implements Displayer {

	private String fileName;
	

	@Override
	public void input(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getFileName() {

		return this.fileName;
	}

	@Override
	public ValidationResult showResult(ValidationResult res) {

		return res;
	}

}
