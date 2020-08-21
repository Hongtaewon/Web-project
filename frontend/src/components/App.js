import React from "react";
import {
  Route,
  Switch,
} from 'react-router-dom';
import {home,NotFoundPage,blog_main} from 'pages';
import axios from 'axios';
import APIMessage from 'pages/blog/APIMessage'

export default class App extends React.Component {

  getTest = async () => {
    //const {data} = await axios.get("/test");

var test = {
  "idx": null,
  "loginid": "12",
  "name": "22",
  "nick_name": "33",
  "password": "44",
  "email": "55",
  "auth": 0,
  "password_cnt": 0,
  "last_login_try_Date": null,
  "is_lock": 0,
  "createdDate": null,
  "modifiedDate": null
};

  var message = new APIMessage("test",test,"OK","이런");

  console.log(message);

  axios.post("/blog/Auth/signIn", message)
  .then((response) => {
    console.log(response);
  },
  (error) => {
    console.log(error);
  });;

  };

  componentDidMount() {
    this.getTest();
  }

  render() {

    return (
      <div>
        <Switch>       
          <Route exact path="/" component={home} />
          <Route path="/blog/:id" component={blog_main} /> 
          <Route component={NotFoundPage} />
        </Switch>
      </div>
    )
  }
}