import React from "react";
import {
  Route,
  Switch,
} from 'react-router-dom';
import {home,NotFoundPage,blog_main} from 'pages';
import LoginContainer from 'container/LoginContainer';

export default class App extends React.Component {

  componentDidMount() {
  }

  render() {

    return (
      <div>
        
        {/*<Route path="/register" component={RegisterContainer} />*/}

        <Switch>       
          <Route exact path="/" component={home} />
          <Route path="/blog/:id" component={blog_main} /> 
          <Route path="/login" component={LoginContainer} />
          <Route component={NotFoundPage} />
        </Switch>
      </div>
    )
  }
}