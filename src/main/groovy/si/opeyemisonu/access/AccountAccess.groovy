package si.opeyemisonu.access

import com.mongodb.DB
import org.bson.types.ObjectId
import org.jongo.Jongo
import org.jongo.MongoCollection
import si.opeyemisonu.model.Account

class AccountAccess {
    private static String COLLECTION_NAME = 'account'

    private MongoCollection accountCollection 

    AccountAccess(DB mongoDB) {
        this(new Jongo(mongoDB))
    }

    AccountAccess(Jongo jongo) {
        this.accountCollection = jongo.getCollection(COLLECTION_NAME)
    }

    def String save(Account account) {
        try {
            def result = accountCollection.save(account)
            return result.upsertedId
        } catch (Exception throwable) {
            throw new MongoAccessException("Failed to insert account=" + account, throwable)
        }
    }
    
    def Account getByEmail(String email) {
        try {
            return accountCollection.findOne("{email: #}", email).as(Account.class)
        } catch (Exception throwable) {
            throw new MongoAccessException("Couldn't retrieve account. email=" + email, throwable)
        }
    }

    def Account getById(String idString) {
        try {
            return accountCollection.findOne("{_id: #}", new ObjectId(idString)).as(Account.class)
        } catch (Exception throwable) {
            throw new MongoAccessException("Couldn't retrieve account. id=" + idString, throwable)
        }
    }
    
    List<Account> getAll() {
        def cursor = null
        try {
            cursor = accountCollection.find().as(Account.class)
            
            def accounts = new ArrayList<>()
            while(cursor.hasNext()) {
                accounts.add(cursor.next())
            }
            
            return accounts
        } catch (Throwable throwable) {
            throw new MongoAccessException("Couldn't retrieve accounts.",  throwable)
        } finally {
            cursor?.close()
        }
    }
}
