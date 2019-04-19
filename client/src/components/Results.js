import React from 'react';

//stateless function
const Results = (props) => (
	
	<div className="container results">
		<nav className="navbar-light bg-light">
			<h1>Overview:</h1>

			<p>Tweets containing this keyword "<b>{ props.location.state.keyword}</b>"</p> 
			<p>They have been published: <b>17/04/2019</b></p> 
		</nav>

		<div className="spacerup"></div>
		 <h1>Statistics:</h1>
		 <div className="panel panel-default border">
	      <div className="panel-body">
	        <div className="row">
		          <div className="col-sm-3">
		            <div className="statistic">
		            	  <div className="label">Total Likes</div>
		            	  <div className="value">{ props.location.state.totalLike }</div>
		            </div>
		          </div>

		          <div className="col-sm-3">
		            <div className="statistic">
		             	 <div className="label">Total Shares</div>
		             	 <div className="value">{ props.location.state.totalShared }</div>
		            </div>
		          </div>

		          <div className="col-sm-3">
		            <div className="statistic">
		             	 <div className="label">Retweets Percentage</div>
		             	 <div className="value">{ props.location.state.percentageTweet } %</div>
		            </div>
		          </div>

		          <div className="col-sm-3">
		            <div className="statistic">
		             	 <div className="label">% Tweets with Hashtag</div>
		             	 <div className="value">{ props.location.state.percentageHashtag } %</div>
		            </div>
		          </div>

		           <div className="col-sm-3">
		            <div className="statistic">
		             	 <div className="label">% Tweets with Media</div>
		             	 <div className="value">{ props.location.state.percentageMedia } %</div>
		            </div>
		          </div>
	      </div>
	    </div>
	    </div>
	   
	    <div className="spacerup"></div>

	    <center><h1>View More Details</h1></center>

	    <div className="spacer"></div>

		<div className="table-responsive-md">

            <table className="table table-hover table-bordered">
			  <thead  className="thead-dark">
			    <tr>
			      <th scope="col">Tweet Id</th>
			      <th scope="col">Tweet</th>
			      <th scope="col">Nb Likes</th>
			      <th scope="col">Nb Shares</th>
			      <th scope="col">Username</th>
			    </tr>
			   </thead>

				<tbody>
				{ props.location.state.tweets.map((tweet) => {
		            return (		  
						    <tr>
						      <td scope="row">{ tweet.id }</td>
						      <td>{ tweet.text }</td>
						      <td>{ tweet.favoriteCount }</td>
						      <td>{ tweet.retweetCount }</td>
						      <td>{ tweet.user.name }</td>
						    </tr> 
		                );

		        	 })
		         }

				</tbody>
			</table>

		</div>

	</div>

);
 

export default Results;