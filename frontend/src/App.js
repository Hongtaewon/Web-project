import React from "react";
import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from 'react-router-dom';
import axios from "axios";
import APIMessage from "./page/blog/APIMessage"


export default class App extends React.Component {


  getTest = async () => {
      //const {data} = await axios.get("/test");

  var test = {
    test: "test",
    type: "type"
  };

  var message = new APIMessage("Member",test,"OK","이런");
  
  console.log(message);

  axios.post("/test11", message);

  };

  _redirectToHome() {
    return <Redirect to="/" />;
  }

  componentDidMount() {
    this.getTest();
  }
  render() {
    return (

      <Router>
        <div>

          {/* content */}

          <Switch>
            {/* Post List*/}

            <Route render={this._redirectToHome} />

          </Switch>
        </div>
      </Router>
    )
  }
}