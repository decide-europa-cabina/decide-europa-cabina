import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class Voting extends Component {
  render() {
    return <div id="voting">Voting page - <Link to="/">Go to Home</Link></div>;
  }
}
