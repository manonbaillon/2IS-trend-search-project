import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";

import App from '../App';
import Results from './Results';
import Error404 from './Error404';
import Login from './Login';
import Logout from './Logout';
import Signup from './Signup';

const Router = () => (

	<BrowserRouter>
		<Switch>

			<Route path="/app/" component={App} exact />

			<Route path="/" component={Login} exact />

			<Route path="/signup" component={Signup} exact />

			<Route path="/results/" component={Results} exact />

			<Route path="/404/" component={Error404} exact/>

			<Route path="/logout/" component={Logout} exact />

		</Switch>
		


	</BrowserRouter>
	);

 export default Router;