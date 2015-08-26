package si.opeyemisonu.access

class MongoAccessException extends RuntimeException {
    def MongoAccessException(String message, Throwable t) {
        super(message, t)
    }
}
