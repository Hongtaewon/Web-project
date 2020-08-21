export default function APIMessage(tableName,object,result,reason) {

    var APIMessage= {

        Header:{
            "event_id": "",
            "request_id": "test",
            "eventTime": "test"
        },
    
        Body: {
            "Any":{
    
            },
            "innerMap": {

            }
        },
    
        Return: {
            "result":"Fail",
            "reason":"와이"
        }
    };
    
    APIMessage.Header.event_id = "blog-" + tableName;
    APIMessage.Header.eventTime = new Date().toJSON();
    APIMessage.Body.Any = object;
    APIMessage.Return.result = result;
    APIMessage.Return.reason = reason;

    return APIMessage;
}