import React from 'react';

class Error404 extends React.Component {

	render() {

		return (
			 <div className="wrapper">
				 <div className="main">
				    <div className="container">		
						<div className="section group">
							<div className="notfound"> 
								<h2>
									<span>404</span>
									<br />
									<img width="300" alt="Work in Progress" src="https://bits.theorem.co/images/posts/the-state-of-frontend-development-with-IPFS-in-2017/developer-wip.png"/>
								</h2>
								
							</div>
						  </div>
				       <div className="clear"></div>
				    </div>
				 </div>
			</div>

		);
	}
}

export default Error404;