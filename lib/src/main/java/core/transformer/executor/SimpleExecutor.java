package core.transformer.executor;

import core.common.MessageInterface;
import core.transformer.compostiteFile.CompositeFile;
import core.transformer.executor.message.ResultMessage;

public class SimpleExecutor implements FileChangeExecutor {

	@Override
	public MessageInterface execute(CompositeFile fileResult) {
		
		try {
			
			fileResult.execute();
			
		}finally {
			
		}
		
		
		return new ResultMessage();
		
	}

}
