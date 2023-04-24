package file;

import java.io.File;

import org.junit.jupiter.api.Test;

public class Test1 {

	@Test
	public void t() {
		
		File f = new File("C:\\Users\\FBG\\Downloads\\go\\123.txt");
		System.out.println(f);
		f.renameTo(new File("C:\\Users\\FBG\\Downloads\\go\\main.go123"));
		f.delete();
	}
}
