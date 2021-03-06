package si.opeyemisonu.controller

import si.opeyemisonu.access.AccountAccess
import si.opeyemisonu.model.Account

class AccountController {
    private AccountAccess mongoAccountAccess

    AccountController(AccountAccess mongoAccountAccess) {
        this.mongoAccountAccess = mongoAccountAccess
    }
    
    def String newAccount(Account account) {
        return mongoAccountAccess.save(account)
    }

    def Account getById(String idString) {
        return mongoAccountAccess.getById(idString)
    }

    def Account getByEmail(String email) {
        return mongoAccountAccess.getByEmail(email)
    }

    def Account getByAuthDetails(authDetails) {
        def account = getByEmail(authDetails.email)
        if (account == null || account.password != authDetails.pwd) {
            return null
        }
        account
    }
    
    def getAll() {
        return mongoAccountAccess.getAll()
    }
}
