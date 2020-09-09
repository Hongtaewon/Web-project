import React from 'react';
import classNames from 'classnames/bind';
import { Container } from '@material-ui/core';


const cx = classNames.bind(styles);

const PageTemplate = ({ header, children }) => {
  return (
    <div>
      <header>
        {header}
      </header>
      <main>
        <Container>
          {children}
        </Container>
      </main>
    </div>
  )
};

export default PageTemplate;