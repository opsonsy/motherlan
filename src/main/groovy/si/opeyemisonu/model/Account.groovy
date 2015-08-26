package si.opeyemisonu.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.ToString
import org.bson.types.ObjectId

@ToString
class Account {
    ObjectId _id
    String email, firstName, lastName, city, zipCode, gender, occupation
    Integer age
    @JsonIgnore
    String password
}
