import React, { Fragment } from 'react';
import { Button } from '@material-ui/core';

const loginMenuitem = (
    <>
        <Button variant="contained" color="primary" href="/login">
            SignIn
        </Button>
        <Button variant="contained" color="secondary" href="/register">
            SignUp
        </Button>  
    </>
);

const accountMenuItem = (
    <>
        <Button variant="contained" color="primary">
            MyPage
        </Button>
        <Button variant="contained" color="secondary">
            LogOut
        </Button>          
    </>
);

const LoginMenu = ({isAuthenticated}) => {
    
    return (
        <Fragment>
            {isAuthenticated ? accountMenuItem : loginMenuitem},
            <div>
                {isAuthenticated}
            </div>
        </Fragment>

    );
};

export default LoginMenu;