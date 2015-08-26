package si.opeyemisonu.access

import org.bson.types.ObjectId
import org.jongo.Jongo
import si.opeyemisonu.model.Account
import spock.lang.Specification
import spock.lang.Subject

class AccountAccessTest extends Specification {
    
    def accountCollection
    @Subject AccountAccess accountAccess
    
    def setup() {
        def jongo = new Jongo(MongoFactory.getDB("localhost", 27017, "motherlan"))
        accountCollection = jongo.getCollection("account")
        accountAccess = new AccountAccess(jongo)
    }
    
    def "should save account details"() {
        given:
            def account = new Account()
        
        when:
            def accountId = accountAccess.save(account)
        
        then:
            accountId == account._id.toHexString()
    }
    
    def "should look up account by email"() {
        given:
            def account = new Account(email: new ObjectId().toHexString() + "@test.com")
            accountCollection.insert(account)
            
        when:
            def dbAccount = accountAccess.getByEmail(account.email)
        
        then:
            dbAccount.email == account.email
            dbAccount._id == account._id
    }

    def "should look up account by id"() {
        given:
            def account = new Account(_id: new ObjectId())
            accountCollection.insert(account)

        when:
            def dbAccount = accountAccess.getById(account._id.toHexString())

        then:
            dbAccount._id == account._id
    }
    
}
