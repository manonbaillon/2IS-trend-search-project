import React from 'react';


class LanguageBtn extends React.Component {

	

	render() {

		return (

			<div>
				<div className="float-right">
					<button type="button" className="btn btn-outline-secondary">EN</button>
					<button type="button" className="btn btn-outline-dark">FR</button>
				</div>

			</div>
		);
	}
}

	

export default LanguageBtn;