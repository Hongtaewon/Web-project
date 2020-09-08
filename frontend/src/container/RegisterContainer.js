import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { Redirect } from 'react-router-dom';
import * as authActions from "store/modules/auth";
import RegisterForm from 'components/register/RegisterForm';
import APIMessage from 'pages/blog/APIMessage'
import {Button, Dialog, DialogTitle, DialogActions} from '@material-ui/core';

class RegisterContainer extends Component {


  state = {
    open : false,
  }

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
      this.handleOpen();
    }
  };
  
  handleOpen = () => {
    this.setState({open:true});
  }

  handleClose = () => {
    this.setState({open:false});
  };

  componentDidUpdate() {

  }

  render() {

    const { location, Registersuccess } = this.props;
    const { from } = location.state || { from: { pathname: '/', search: location.search } };
    var {RegisterError, ErrorField} = this.props;

    if (Registersuccess) {
      return <Redirect to={from} />;
    }



    return (
      <div>
        <Dialog
            open={this.state.open}
            onClose={this.handleClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
          >   
          <DialogTitle id="alert-dialog-title">
            {ErrorField+"가 이미 사용중입니다."}
          </DialogTitle>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary" autoFocus>
              OK
            </Button>
          </DialogActions>
        </Dialog>
        <RegisterForm handleResiger={this.handleResiger.bind(this)} dRegisterError={RegisterError} ErrorField={ErrorField}/>
      </div>
    );
  }
}

export default connect(
  state => ({
    Registersuccess: state.pender.success["auth/REGISTER"],
    RegisterError: state.pender.failure["auth/REGISTER"],
    ErrorField: state.auth.get("ErrorField"),
  }),
  dispatch => ({
    AuthActions: bindActionCreators(authActions, dispatch)
  })
)(RegisterContainer);

