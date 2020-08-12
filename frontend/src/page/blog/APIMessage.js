import React from 'react';




export default function APIMessage(tableName) {

    var APIMessage= {

        Header:{
            "event_id": "",
            "request_id": "test",
            "eventTime": "test"
        },
    
        Body: {
            "Any":{
    
            }
        },
    
        Return: {
            "result":"Fail",
            "reason":"와이"
        }
    };
    
    APIMessage.Header.event_id = "blog-" + tableName;
    APIMessage.Header.eventTime = new Date().toJSON();


    return APIMessage;
}