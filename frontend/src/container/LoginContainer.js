import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { Redirect } from 'react-router-dom';
import * as authActions from "store/modules/auth";
import LoginForm from 'components/login/LoginForm';
import APIMessage from 'pages/blog/APIMessage'
class LoginContainer extends Component {


  handleLogin = async (username, password,remember) => {
    const { AuthActions } = this.props;
    const member = {
      "loginid":username,
      "password":password
    }

    var message = new APIMessage("Member",member,"","");

    try {
      await AuthActions.login(message);
    } catch (e) {
      console.log("error log :" + e);
    }
  };


  componentDidUpdate() {
  }

  render() {

    const { location, isAuthenticated } = this.props;
    const { from } = location.state || { from: { pathname: '/', search: location.search } };


    if (isAuthenticated) {
      return <Redirect to={from} />;
    }

    return (  
      <LoginForm handleLogin={this.handleLogin.bind(this)}/>
    );
  }
}

export default connect(
  state => ({
    loading: state.pender.pending["auth/LOGIN"],
    loginError: state.pender.failure["auth/LOGIN"],
    isAuthenticated: state.auth.get("isAuthenticated"),
  }),
  dispatch => ({
    AuthActions: bindActionCreators(authActions, dispatch)
  })
)(LoginContainer);

