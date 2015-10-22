package si.opeyemisonu.access

import org.jongo.Jongo
import org.jongo.MongoCollection
import si.opeyemisonu.model.AuthSession
import si.opeyemisonu.model.MeetUpRequest

class MeetingRequestAccess {
    private static final String COLLECTION_NAME = 'MeetupRequest'
    
    private final MongoCollection meetups

    MeetingRequestAccess(Jongo jongo) {
        this.meetups = jongo.getCollection(COLLECTION_NAME)
    }

    String save(MeetUpRequest request) {
        def result = meetups.save(request)
        result.upsertedId
    }
}
