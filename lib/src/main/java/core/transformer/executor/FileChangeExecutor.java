package core.transformer.executor;

import core.common.MessageInterface;
import core.transformer.compostiteFile.CompositeFile;

public interface FileChangeExecutor {

	public MessageInterface execute(CompositeFile fileResult);

}
