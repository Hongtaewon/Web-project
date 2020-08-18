import React from "react";
import {
  Route,
  Switch,
} from 'react-router-dom';
import {home,NotFoundPage,blog_main} from 'pages';

export default class App extends React.Component {

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