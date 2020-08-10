import React from "react";
import axios from "axios";

export default class App extends React.Component {
  state = {
    isLoading: true,
  };
  getMembers = async () => {
    const { data
    } = await axios.get(
      "/members"
    );
    this.setState({ data, isLoading: false });
  };
  componentDidMount() {
    this.getMembers();
  }
  render() {
    const { isLoading, data } = this.state;

    console.log(data);
    return (
      <section className="container">
        {isLoading ? (
          <div className="loader">
            <span className="loader__text">Loading...</span>
          </div>
        ) : (
          <div className="movies">
            {data.map(d => 
              <div key={d.idx}> id: {d.loginid} name: {d.name} nickname: {d.nick_name} email: {d.email} </div>
              )}
          </div>
        )
        }
      </section>
    );
  }
}