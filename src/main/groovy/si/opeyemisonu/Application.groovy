package si.opeyemisonu

import com.mongodb.DB
import groovy.json.JsonSlurper
import si.opeyemisonu.access.AccountAccess
import si.opeyemisonu.access.MongoFactory
import si.opeyemisonu.controller.AccountController
import si.opeyemisonu.model.Account

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.*
import static spark.Spark.*

class Application {
    
    public static void main(String[] args) {
        final DB db = MongoFactory.getDB("localhost", 27017, "motherlan")
        final AccountController accountController = new AccountController(new AccountAccess(db))
        def jsonSlurper = new JsonSlurper()
        
        port(9090)
        
        get("/accounts/:id", {req, res -> 
            def id = req.params("id")
            def account = accountController.getById(id)
            if(account == null) {
                res.status(SC_BAD_REQUEST)
                return "BAD_REQUEST"
            } else {
                res.status(SC_OK)
                res.type("application/json")
                return account
            }
        })
        
        post("/accounts", {req, res -> 
            def account = new Account(jsonSlurper.parseText(req.body()))
            accountController.newAccount(account)
            res.status(201)
            return account._id
        })
        
        get("/login", {req, res ->
            def loginReq = jsonSlurper.parseText(req.body())
            def account = accountController.getByEmail(loginReq.email)
            if(account == null || account.password != loginReq.pwd) {
                res.status(SC_BAD_REQUEST)
                return "BAD_REQUEST"
            } else {
                res.status(SC_OK)
                res.type("application/json")
                return account
            }
            
        })
        
        
    }
}
