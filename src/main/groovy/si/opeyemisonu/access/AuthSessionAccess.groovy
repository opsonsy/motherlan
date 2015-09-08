package si.opeyemisonu.access

import org.bson.types.ObjectId
import org.jongo.Jongo
import org.jongo.MongoCollection
import si.opeyemisonu.model.AuthSession

/**
 * Created by opeyemi_sonusi on 8/29/15.
 */
class AuthSessionAccess {
    private static final String COLLECTION_NAME = 'AuthSession'

    private final MongoCollection sessionCollection

    AuthSessionAccess(Jongo jongo) {
        this.sessionCollection = jongo.getCollection(COLLECTION_NAME)
    }

    String save(AuthSession session) {
        def result = sessionCollection.save(session)
        result.upsertedId
    }
}
