import React from 'react';

import { withRouter } from "react-router-dom";

class SearchEngine extends React.Component {

	state = {
    	tweets: [],
    	totalLike: undefined

  }

 	getTrend = async (e) => {

		e.preventDefault();

		const keyword = e.target.keyword.value;
		const socialNetwork = e.target.SocialNetwork.value;

		//console.log(socialNetwork);

	    const api_call = await fetch(`http://localhost:8081/trend/${socialNetwork}?keyword=${keyword}`); //make API call
	    const totalLike = await fetch(`http://localhost:8081/trend/${socialNetwork}/totalLike?keyword=${keyword}`); //make API call
	    const totalShared = await fetch(`http://localhost:8081/trend/${socialNetwork}/totalShared?keyword=${keyword}`);
	    const percentageTweet= await fetch(`http://localhost:8081/trend/${socialNetwork}/percentRetweet?keyword=${keyword}`);
	    const percentageHashtag= await fetch(`http://localhost:8081/trend/${socialNetwork}/percentHashtag?keyword=${keyword}`);
	    const percentageMedia= await fetch(`http://localhost:8081/trend/${socialNetwork}/percentMedia?keyword=${keyword}`);


	    const data = await api_call.json(); 
	    const totalLikedata = await totalLike.json();
	    const totalShareddata = await totalShared.json();  
	    const percentageTweetdata = await percentageTweet.json(); 
	    const percentageHashtagdata = await percentageHashtag.json();  
	    const percentageMediadata = await percentageMedia.json();  

	    //console.log(totalLike);

	    if (keyword && socialNetwork === 'twitter') {

        //console.log(this.state.tweets);
        console.log('success');

         this.props.history.push({
             pathname: '/results/',
             state: { tweets: data,
             		  keyword: keyword,
             		  socialNetwork: socialNetwork,
             		  totalLike: totalLikedata,
             		  totalShared: totalShareddata,
             		  percentageTweet: percentageTweetdata,
             		  percentageHashtag: percentageHashtagdata,
             		  percentageMedia: percentageMediadata

             		}
         } )
        
      } 

      else if (keyword && socialNetwork !== 'twitter') {

        this.props.history.push({
             pathname: '/404/',
             state: { tweets: undefined,
          			  error: "Please enter the values"
             		}
         } )
      } 

    else {
        this.setState({
          tweets: undefined,
          error: "Please enter the values"
        });
      }
     
	}


	render() {
		return (

			<div>
				<h3 className="spacer">Search Engine</h3>
				<form onSubmit={this.getTrend.bind(this)}>
                <div className="input-group md-form form-sm form-2 pl-0">
               	 	
               	 		<input className="form-control my-0 py-1 red-border" type="text" name="keyword" placeholder="Enter your keyword" aria-label="Search" />
               	 	
	                <div className="input-group-append">
	                  <button className="input-group-text red lighten-3" id="basic-text1">
	                  	
	                  		<i className="fa fa-search text-grey" aria-hidden="true"></i>
	                  	
	                  	</button>
	                </div>
                </div>


                <h5 className="spacer-top">Your Social Network: </h5>
	                <div className="custom-control custom-radio">
					  <input type="radio" className="custom-control-input" id="defaultChecked2" name="SocialNetwork" value="twitter" />
					  <label className="custom-control-label" for="defaultChecked2">Twitter</label>
					</div>
					<div className="custom-control custom-radio">
					  <input type="radio" className="custom-control-input" id="defaultChecked3"  name="SocialNetwork" value="reddit" />
					  <label className="custom-control-label" for="defaultChecked3">Reddit</label>
					</div>
					<div className="custom-control custom-radio">
					  <input type="radio" className="custom-control-input" id="defaultChecked4" name="SocialNetwork" value="facebook"  />
					  <label className="custom-control-label" for="defaultChecked4">Facebook</label>
					</div>
					<div className="custom-control custom-radio">
					  <input type="radio" className="custom-control-input" id="defaultChecked5" name="SocialNetwork"  value="tumblr" />
					  <label className="custom-control-label" for="defaultChecked5">Tumblr</label>
					</div>
                </form>
			</div>
		)
	}
}

export default withRouter(SearchEngine);