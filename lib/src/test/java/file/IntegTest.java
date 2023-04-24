package file;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import core.transformer.SimpleTransformer;
import core.transformer.Transformer;
import core.validator.ParamValidator;
import core.validator.SimpleParamValidator;
import displayer.Displayer;
import displayer.SimpleDisplayer;

public class IntegTest {

	@Test
	public void t() {
		
		Displayer displayer = new SimpleDisplayer();
		ParamValidator valid = new SimpleParamValidator();
		Transformer trans = new SimpleTransformer();
		
		FileTransformer transformer = new FileTransformer(displayer, valid, trans);
		assertNotNull(transformer);;
		
		
	}
}
