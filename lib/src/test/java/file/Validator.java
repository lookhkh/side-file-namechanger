package file;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.message.ValidationResult;
import core.validator.ParamValidator;
import core.validator.SimpleParamValidator;

public class Validator {

	@Test
	public void validator() {
		ParamValidator val = new SimpleParamValidator();
		assertNotNull(val);
	}
	
	@Test
	@DisplayName("생성자가 없을 시 validate는 default로 fallback한다.")
	public void validator5() {
		ParamValidator val = new SimpleParamValidator();
		assertNotNull(val);
		ValidationResult res =  val.validate("12312");
		assertFalse(res.isResult());
		
		ValidationResult res2 =  val.validate("asdasdasd1232.jpeg");
		assertTrue(res2.isResult());

	}
	
	@Test
	@DisplayName("생성자로 주어진 패턴에 맞지 않은 파일 형식이 올 경우 에러 메시지를 반환한다.")
	public void validator2() {
		
		String pattern = "[a-zA=Z]";
		ParamValidator val = new SimpleParamValidator(pattern);
		assertNotNull(val);
		
		String invalidPattern = "123";
		
		ValidationResult message = val.validate(invalidPattern);
		
		assertNotNull(message);
		assertFalse(message.isResult());
		
	}
	
	@Test
	@DisplayName("생성자로 주어진 패턴에 맞는 file을 입력하면 성공한다..")
	public void validator3() {
		
		String pattern = "[1-9]{1,}\\.\\D*";
		ParamValidator val = new SimpleParamValidator(pattern);
		assertNotNull(val);
		
		String invalidPattern = "123.file";
		
		ValidationResult message = val.validate(invalidPattern);
		
		assertNotNull(message);
		assertTrue(message.isResult());
		
	}
}
