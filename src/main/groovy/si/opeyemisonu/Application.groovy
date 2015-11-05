package si.opeyemisonu

import com.mongodb.DB
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.jongo.Jongo
import si.opeyemisonu.access.AccountAccess
import si.opeyemisonu.access.AuthSessionAccess
import si.opeyemisonu.access.MongoFactory
import si.opeyemisonu.controller.AccountController
import si.opeyemisonu.controller.AuthSessionController
import si.opeyemisonu.model.Account

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.*
import static spark.Spark.*

class Application {
    
    public static void main(String[] args) {
        final Jongo jongo = new Jongo(MongoFactory.getDB("192.168.99.100", 28017, "motherlan"))
        final AccountController accountController = new AccountController(new AccountAccess(jongo))
        final AuthSessionController authSessionController = new AuthSessionController(new AuthSessionAccess(jongo))
        def jsonSlurper = new JsonSlurper()
        
        port(9090)

        staticFileLocation("/public")
        
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

        get("/accounts", {req, res ->
            def accounts = accountController.getAll()
            if(accounts == null) {
                res.status(SC_BAD_REQUEST)
                return "BAD_REQUEST"
            } else {
                res.status(SC_OK)
                res.type("application/json")
                return accounts
            }
        })
        
        post("/accounts", {req, res -> 
            def account = new Account(jsonSlurper.parseText(req.body()))
            accountController.newAccount(account)
            res.status(201)
            return account._id
        })
        
        post("/auth", {req, res ->
            def loginReq = jsonSlurper.parseText(req.body())
            def account = accountController.getByAuthDetails(loginReq)
            if(account == null) {
                res.status(SC_BAD_REQUEST)
                return "BAD_REQUEST"
            } else {
                def authSession = authSessionController.createSession(account)
                res.status(SC_OK)
                res.type("application/json")
                def json = new JsonBuilder()
                json {
                    token authSession.token
                }
                return json.toString()
            }
        })
        
        post("/requests", {req, res ->
            
            
        })
        
        post("/reset", {req, res ->
            def email = req.body()
            res.status(201)
            return email
        })

        post("/test", {req, res ->
//            res.status(201)
        })        
        
        
    }
}
