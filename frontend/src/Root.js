import React from 'react';
import { BrowserRouter,Route } from 'react-router-dom';
import App from 'components/App';
import { Provider } from 'react-redux';

const Root = () => {
  return (
      <BrowserRouter>
        <Route path="/" component={App} />
      </BrowserRouter>
  );
}

export default Root;