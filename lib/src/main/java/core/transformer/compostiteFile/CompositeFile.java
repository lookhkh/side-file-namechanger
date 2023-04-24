package core.transformer.compostiteFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositeFile {
	
	private String fileName;
	private List<CompositeFile> childs;
	
	public CompositeFile(String fileName) {
		this.fileName = fileName;
		this.childs = new ArrayList<>();
	}

	public CompositeFile(File child) {
		this.fileName = child.getAbsoluteFile().getAbsolutePath();
		this.childs = new ArrayList<>();

	}

	public String getFileName() {
		return this.fileName;
	}

	public List<CompositeFile> getChilds() {
		return this.childs;
	}

	public void appendChild(File child) {
		

		this.addChild(child);
		
	}

	private void addChild(File child) {
		
		CompositeFile file = new CompositeFile(child.getParent().concat("\\").concat(child.getName()));
		this.childs.add(file);
		
	}

	public void appendChild(CompositeFile subRoot) {
		this.childs.add(subRoot);
		
	}

	@Override
	public String toString() {
		return "CompositeFile [fileName=" + fileName + ", childs=" + childs + "]";
	}

	public long size() {
		
		long size = this.childs.stream()
								.filter(t->t.isFile())
								.count();
		
		for(CompositeFile f : this.childs) {
			size+=f.size();
		}
		
		return size;
	}

	private boolean isFile() {
		// TODO Auto-generated method stub
		return this.childs.size() <= 0;
	}

	public void execute() {
		File file = new File(this.fileName);
			
		String now = LocalDateTime.now().toString().substring(0,10);
		
		
		
		if(this.childs.size()>0)this.childs
									.stream()
									.forEach(t->t.execute());


		File newFile = new File(file.getAbsolutePath()+now);
		file.renameTo(newFile);
		
		
		
		System.out.println(newFile.exists()+"  "+newFile);
		

	}

	

}
