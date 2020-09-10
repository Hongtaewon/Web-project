import React from 'react';
import { Container } from '@material-ui/core';


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