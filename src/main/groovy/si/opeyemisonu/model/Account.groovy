package si.opeyemisonu.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString
import org.bson.types.ObjectId

@ToString
class Account {
    ObjectId _id
    String email, firstName, lastName, city, zipCode, gender, occupation
    Integer age
    String password

    @JsonIgnore
    String getPassword() {
        return password
    }

    @JsonProperty
    void setPassword(String password) {
        this.password = password
    }
}
