package si.opeyemisonu.controller

import org.bson.types.ObjectId
import si.opeyemisonu.access.AuthSessionAccess
import si.opeyemisonu.model.Account
import si.opeyemisonu.model.AuthSession

/**
 * Created by opeyemi_sonusi on 8/29/15.
 */
class AuthSessionController {
    private AuthSessionAccess authSessionAccess

    AuthSessionController(AuthSessionAccess authSessionAccess) {
        this.authSessionAccess = authSessionAccess
    }

    AuthSession createSession(Account account) {
        def date = new Date()
        def session = new AuthSession(startDate: date,
                validTill: date + 30, accountId: account._id, email: account.email, token: new ObjectId().toHexString())
        authSessionAccess.save(session)
        return session
    }
}
