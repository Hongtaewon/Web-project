import React, { Component } from 'react';
import { connect } from 'react-redux';
import SideNav from 'components/home/Sidenav';
import { bindActionCreators } from "redux";
import * as authActions from "store/modules/auth";

class SidenavContainer extends Component {



  componentDidUpdate() {
    console.log(this.props.isAuthenticated);
  
  }

  

  handleLogout = () => {
    const { AuthActions } = this.props;
    AuthActions.logout();   
  }


  render() {

    const { isAuthenticated } = this.props;

    return ( 
        <SideNav isAuthenticated={isAuthenticated} onLogout={this.handleLogout}/>
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
)(SidenavContainer);

