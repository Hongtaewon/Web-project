import React from "react";
import {
  Route,
  Switch,
} from 'react-router-dom';
import {home,NotFoundPage,blog_main} from 'pages';
import LoginContainer from 'container/LoginContainer';
import * as authActions from "store/modules/auth";
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";

class App extends React.Component {


  

  componentDidMount() {
    const { AuthActions } = this.props;    
    AuthActions.getUser();
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

export default connect(
  state => ({   
  }),
  dispatch => ({
    AuthActions: bindActionCreators(authActions, dispatch)
  })
)(App);