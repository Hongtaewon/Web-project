import React from 'react';
import {PostListPage, PostPage, EditorPage, NotFoundPage } from 'pages';
import {
    Route,
    Switch,
  } from 'react-router-dom';

const main = () => {
    return (
    <div>
        <Switch>
          <Route exact path="/blog/:id" component={PostListPage} /> 
          <Route path="/blog/:id/posts/:id" component={PostPage} /> 
          <Route path="/blog/:id/postwrite" component={EditorPage} />
          <Route component={NotFoundPage} />
        </Switch>
    </div>


    );
};

export default main;