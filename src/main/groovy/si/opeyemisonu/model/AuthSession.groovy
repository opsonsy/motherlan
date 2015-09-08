package si.opeyemisonu.model

import org.bson.types.ObjectId
import org.jongo.marshall.jackson.oid.MongoObjectId

/**
 * Created by opeyemi_sonusi on 8/29/15.
 */
class AuthSession {
    @MongoObjectId
    String token
    String email
    ObjectId accountId
    Date startDate
    Date validTill
}
