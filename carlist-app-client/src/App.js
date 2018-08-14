import React, { Component } from "react";
import "./App.css";
import Login from "./components/Login.js";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";

class App extends Component {
  render() {
    return (
      <div className="App">
        <AppBar position="static" color="default">
          <Toolbar>
            <Typography variant="title" color="inherit">
              Car List
            </Typography>
          </Toolbar>
        </AppBar>
        <Login />
      </div>
    );
  }
}

export default App;
