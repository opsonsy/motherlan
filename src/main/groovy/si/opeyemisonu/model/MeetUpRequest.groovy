package si.opeyemisonu.model

class MeetUpRequest {
    String what
    Date when
    Date expirationDate
    Account requester
    String where
    String whoIsPaying
    List<MeetUpCondition> conditions
}
