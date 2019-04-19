import React, { Component } from 'react';
import './App.css';
import LanguageBtn from './components/LanguageBtn';
import User from './components/User';
import Title from './components/Title';
import MapImage from './components/MapImage';
import SearchEngine from './components/SearchEngine';
import { Redirect, withRouter } from "react-router-dom";

class App extends Component {
    constructor (props){
     super(props) 
     const user = props.location.state.user;
     const email = props.location.state.email;
     const password = props.location.state.password;
     const id = props.location.state.id;

     this.state =  { 
      user: (user)?user:{authenticated:false}
      }

      console.log(email);
      console.log(password);
      console.log(id);

    }


    renderForm() {
      const { user } =  this.state;

     // console.log(user);

      if (user && user.authenticated === true) {
        return (<div>
                  <User />
                  <LanguageBtn />
                  <Title />
                  <div className="row">
                      <div className="col-sm-3">
                        <MapImage />
                      </div>
                      <div className="col-sm-9">
                        <SearchEngine />           
                      </div>
                  </div>    
                 </div>)
      }

      else {
        return (<Redirect to='/' />)

      }
    } 


/*
    componentWillReceiveProps(nextProps) {
      console.log('I am in console will receive props ');
      console.log(nextProps);
    } 

    componentDidUpdate() {
      console.log('I am in componentDidMount ');
      console.log(this.props.location.state);

      let User = this.props.location.state;

      this.setState({
           User
      })

      this.forceUpdate();
    }
*/
  render() {

    return (
      <div>
        <div className="wrapper">
          <div className="main">
            <div className="container">
                 { this.renderForm() }
            </div>
          </div>
        </div>       
      </div>
    );
  }
}

export default withRouter(App);
