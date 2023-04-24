package file;

import core.common.MessageInterface;
import core.message.ValidationResult;
import core.transformer.Transformer;
import core.transformer.compostiteFile.CompositeFile;
import core.transformer.executor.FileChangeExecutor;
import core.transformer.executor.SimpleExecutor;
import core.transformer.executor.message.ResultMessage;
import core.validator.ParamValidator;
import displayer.Displayer;

public class FileTransformer {

	private Displayer displayer;
	private ParamValidator valid;
	private Transformer trans;
	private FileChangeExecutor exec;
	
	public FileTransformer(Displayer displayer, ParamValidator valid, Transformer trans) {
		this.displayer = displayer;
		this.valid = valid;
		this.trans = trans;
		this.exec = new SimpleExecutor();
	}
	
	public FileTransformer(Displayer displayer, ParamValidator valid, Transformer trans,FileChangeExecutor exec) {
		this.displayer = displayer;
		this.valid = valid;
		this.trans = trans;
		this.exec = exec;
	}

	public void insert(String fileName) {
		
		ValidationResult result = this.valid.validate(fileName);
		
		if(!result.isResult()) {
			this.displayer.showResult(result);
		}else {
			
			try {
				CompositeFile fileResult =  this.trans.insert(result).orElseThrow(()->new IllegalStateException("No File"));
				MessageInterface r = this.exec.execute(fileResult);
			}catch(IllegalStateException e) {
				System.err.println(fileName+" not exist");
			}
		}
		
	}
	


}
