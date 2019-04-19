import React from 'react';


class SocialNetwork extends React.Component {

	state = {
    	SocialNetwork: []

  }


  getSocialNetwork = async (e) => {

		e.preventDefault();

		const keyword = e.target.keyword.value;

	    const api_call = await fetch(`http://localhost:8081/trend/twitter?keyword=${keyword}`); //make API call
	    
	    const data = await api_call.json(); 

	    if (keyword) {

        console.log(this.state.tweets);

        this.props.history.push({
             pathname: '/results/',
             state: { tweets: data,
             		  keyword: keyword 
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
				<form onSubmit={this.getSocialNetwork.bind(this)}>
					<h5 className="spacer-top">Your Social Network: </h5>
	                <div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultChecked2" name="SocialNetwork" value="twitter" />
					  <label class="custom-control-label" for="defaultChecked2">Twitter</label>
					</div>
					<div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultChecked3"  name="SocialNetwork" value="reddit" />
					  <label class="custom-control-label" for="defaultChecked3">Reddit</label>
					</div>
					<div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultChecked4" name="SocialNetwork" value="facebook"  />
					  <label class="custom-control-label" for="defaultChecked4">Facebook</label>
					</div>
					<div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultChecked5" name="SocialNetwork"  value="tumblr" />
					  <label class="custom-control-label" for="defaultChecked5">Tumblr</label>
					</div>
				</form>
			</div>
		);
	}
}

export default SocialNetwork;