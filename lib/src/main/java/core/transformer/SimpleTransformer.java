package core.transformer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import core.message.ValidationResult;
import core.transformer.compostiteFile.CompositeFile;

public class SimpleTransformer implements Transformer {
	
	private List<String> igonre;
	
	public SimpleTransformer() {
		this.igonre = new ArrayList<>();
	}
	
	public SimpleTransformer(List<String> igonre) {
		this.igonre = igonre;
	}

	@Override
	public Optional<CompositeFile> insert(ValidationResult validationResult) {

		String fileName = validationResult.getFileName();
		
		if(checkIfFileShouldBeIgonored(fileName)) return Optional.empty();
		
		File f= new File(fileName);
		
		
		if(f.isFile()) {
			return Optional.of( new CompositeFile(fileName) );
		}else if(f.isDirectory()){
			File[] childs =  f.listFiles();
			
			CompositeFile directory = new CompositeFile(fileName);
			
			
			for(File child : childs) {
			
				if(checkIfFileShouldBeIgonored(child.getName())) continue;
				
				if(child.isFile()) directory.appendChild(child);
				else {
					
					CompositeFile subRoot = createSubPathRecursively(child);
					directory.appendChild(subRoot);
					
				}
			}
			
			return Optional.of(directory);
		}
		
		throw new IllegalArgumentException("No Return file");
		
	}

	private boolean checkIfFileShouldBeIgonored(String fileName) {
		
		return igonre.contains(fileName);
	}

	private CompositeFile createSubPathRecursively(File dir) {
		
		CompositeFile root = new CompositeFile(dir);
		
		File[] childs = dir.listFiles();
		
		for(File c : childs) {
			
			if(c.isFile()) root.appendChild(c);
			else if(c.isDirectory()) root.appendChild(this.createSubPathRecursively(c));
			
		}
		
		return root;
	}



}
