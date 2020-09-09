import React, {Component} from 'react';
import Editor from '@toast-ui/editor';
import 'codemirror/lib/codemirror.css'; // Editor's Dependency Style
import '@toast-ui/editor/dist/toastui-editor.css'; // Editor's Style
import {Button} from '@material-ui/core';


var toastEditor;

class PostEditor extends Component {

  constructor(){
    super();
    this.state = {
        content : ''
    };

    this.saveArticle = this.saveArticle.bind(this);
  };

  componentDidMount(){
      toastEditor = new Editor({
          el: document.querySelector('#editSection'),
          height: '500px',
          initialEditType: 'wysiwyg',
          previewStyle: 'vertical',
          hooks: {
            addImageBlobHook: (blob,callback) => {
              const reader = new FileReader();
              reader.onload = e => {

                console.log(e);
                console.log(e.target);
                console.log(e.target.result);
                callback(e.target.result,'custom text')
              };
              
              reader.readAsDataURL(blob);
            }
          }
      });
  };

  saveArticle(){
      const content = toastEditor.getHtml();
      console.log(content);

      this.setState({
          content
      });
  };

  render(){
      return (
          <div id="toastEditor">
              <h1>Post Writer</h1>
              <div id="editSection"></div>
              <Button variant="contained" color="primary" disableElevation onClick={this.saveArticle}>Save</Button>
              <div>
                  <h2>result</h2>
                  <textarea className="tf_result" value={this.state.content} readOnly="readOnly"></textarea>
              </div>
          </div>
      );
  };

};

export default PostEditor;