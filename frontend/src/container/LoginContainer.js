import React, { Component } from 'react';
//import { connect } from 'react-redux';
//import { bindActionCreators } from "redux";
//import { Redirect } from 'react-router-dom';
import {login} from "store/modules/auth";
import LoginForm from 'components/login/LoginForm';

class LoginContainer extends Component {


  handleLogin = async (username, password) => {
    //const { AuthActions } = this.props;

    try {
      await login(username, password);      
    } catch (e) {
      console.log("error log :" + e);
    }
  };

  render() {

    return (  
      <LoginForm handleLogin={this.handleLogin.bind(this)}/>
    );
  }
}

export default LoginContainer;
/*
export default connect(
  state => ({
    loading: state.pender.pending["auth/LOGIN"],
    loginError: state.pender.failure["auth/LOGIN"],
    isAuthenticated: state.auth.get("isAuthenticated")
  }),
  dispatch => ({
    AuthActions: bindActionCreators(authActions, dispatch)
  })
)(LoginContainer);
*/
