import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { Redirect } from 'react-router-dom';
import * as authActions from "store/modules/auth";
import RegisterForm from 'components/register/RegisterForm';
import APIMessage from 'pages/blog/APIMessage'
class RegisterContainer extends Component {


  handleResiger = async (loginid,name, password,email) => {
    const { AuthActions } = this.props;
    const member = {
      "loginid":loginid,
      "name":name,
      "password":password,
      "email":email
    }

    var message = new APIMessage("Member",member,"","");

    try {
      await AuthActions.register(message);
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
      <RegisterForm handleResiger={this.handleResiger.bind(this)}/>
    );
  }
}

export default connect(
  state => ({
    isAuthenticated: state.auth.get("isAuthenticated"),
  }),
  dispatch => ({
    AuthActions: bindActionCreators(authActions, dispatch)
  })
)(RegisterContainer);

