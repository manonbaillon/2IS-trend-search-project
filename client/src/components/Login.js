import React from 'react';
import axios from 'axios';
import { withRouter } from "react-router-dom";

class Login extends React.Component {
	state = {
		email: '',
		password: '',
		id: '',
		error: undefined
	}

	onHandleChangeEmail = (e) => {
		console.log(e.target.value);
		this.setState({
			email: e.target.value
		})

	}

	onHandleChangePassword = (e) => {
		console.log(e.target.value);

		this.setState({
			password: e.target.value
		})

	}

	onHandleClick = (e) => {
		const { email, password } = this.state;

		console.log('You are Login ',  email, password);

		axios.post('http://localhost:8081/loginUser', { email: email, password: password})
			.then(res => { console.log(res)
						if (res.data === 'Authentification succceed') {
							this.props.history.push({
					             pathname: '/app/',
					             state: { user: { authenticated: true },
					             		  email: email,
					             		  password: password,
					             		  id: password }
       						  } )
						} 

						else{

							this.setState({
								error: 'Wrong Email or Password'
							})

						}
			})
	}



	render() {
		return (
			<div className="container">
		    <div className="row">
		      <div className="col-sm-9 col-md-7 col-lg-5 mx-auto">
		        <div className="card card-signin my-5">
		          <div className="card-body">
		        	{ this.state.error }
		          	
		            <h5 className="card-title text-center">Sign In</h5>
		            <div className="form-signin">
		              <div className="form-label-group">
		                <input type="email" id="inputEmail" className="form-control" placeholder="Email address" name="email" value={ this.state.email } onChange={ this.onHandleChangeEmail } required />
		                <label htmlFor="inputEmail">Email address</label>
		              </div>

		              <div className="form-label-group">
		                <input type="password" id="inputPassword" className="form-control" name="password" value={ this.state.password } placeholder="Password"  placeholder="Password" onChange={ this.onHandleChangePassword } required />
		                <label htmlFor="inputPassword">Password</label>
		              </div>

		              <button className="btn btn-lg btn-primary btn-block text-uppercase"  onClick={ this.onHandleClick } >Sign in</button>
		               <hr className="my-4" />
              		  <button className="btn btn-lg btn-google btn-block text-uppercase" >Create an account</button>

		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>

			
		);
	}
}

	

export default  withRouter(Login);