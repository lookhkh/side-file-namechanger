package file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.message.ValidationResult;
import core.transformer.SimpleTransformer;
import core.transformer.Transformer;
import core.transformer.compostiteFile.CompositeFile;
import core.transformer.executor.FileChangeExecutor;
import core.transformer.executor.SimpleExecutor;

public class TransformerTest {
	
	String dir = "C:\\Users\\FBG\\Downloads\\nextjs-course-code-05-prj-data-fetching";
	String filePath =  "C:\\Users\\FBG\\Downloads\\test";
	@Test
	public void t() {
		
		Transformer trans = new SimpleTransformer();
		assertNotNull(trans);
		
	}
	
	@Test
	@DisplayName("트랜스포머는 validationResult 메시지를 수신한다.")
	public void t2() {
		Transformer trans = new SimpleTransformer();
		trans.insert(new ValidationResult(filePath,true));
	}
	
	@Test
	@DisplayName("트랜스포머는 validationResult로 부터 filename을 추출하여, CompositeFile 객체를 리턴한다.")
	public void t3() {
		
		String fileName = dir;
		
		Transformer trans = new SimpleTransformer();
		CompositeFile files = trans.insert(new ValidationResult(filePath, true)).get();
		
		assertEquals(filePath, files.getFileName());
	}
	
	@Test
	@DisplayName("입력으로 주어진 값이 파일일 경우, 단일 개채를 반환한다.")
	public void t4() {
		Transformer trans = new SimpleTransformer();
		CompositeFile file = trans.insert(new ValidationResult(filePath, true)).get();
		
		List<CompositeFile> childs = file.getChilds();
		assertTrue(childs.size() == 0);
		
	}
	
	@Test
	@DisplayName("입력으로 주어진 값이 디렉토리일 경우, 해당 폴더에 있는 모든 파일의 숫자를 반환한다.")
	public void t5() {
		Transformer trans = new SimpleTransformer(Arrays.asList("node_modules",".next","src","public",".git"));
		CompositeFile file = trans
								.insert(new ValidationResult(filePath, true))
								.get();
		
		List<CompositeFile> childs = file.getChilds();
		
		FileChangeExecutor exe = new SimpleExecutor();
		exe.execute(file);
	}
}
