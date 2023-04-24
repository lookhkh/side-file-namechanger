package core.transformer;

import java.util.Optional;

import core.message.ValidationResult;
import core.transformer.compostiteFile.CompositeFile;

public interface Transformer {

	Optional<CompositeFile> insert(ValidationResult validationResult);

}
