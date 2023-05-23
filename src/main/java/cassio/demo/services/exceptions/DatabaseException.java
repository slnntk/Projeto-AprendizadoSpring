package cassio.demo.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class DatabaseException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseException(String message) {
        super(message);
    }
}
