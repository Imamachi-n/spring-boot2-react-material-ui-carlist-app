import React, { Component } from "react";
import SkyLight from "react-skylight";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";

class AddCar extends Component {
  constructor(props) {
    super(props);
    this.state = { brand: "", model: "", year: "", color: "", price: "" };
  }

  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  // Save car and close modal form
  handleSubmit = event => {
    event.preventDefault();
    var newCar = {
      brand: this.state.brand,
      model: this.state.model,
      color: this.state.color,
      year: this.state.year,
      price: this.state.price
    };
    this.props.addCar(newCar);
    this.refs.addDialog.hide();
  };

  // Cancel and close modal form
  cancelSubmit = event => {
    event.preventDefault();
    this.refs.addDialog.hide();
  };

  render() {
    return (
      <div>
        <SkyLight hideOnOverlayClicked ref="addDialog">
          <h3>New Car</h3>
          <form>
            <TextField
              label="Brand"
              type="text"
              placeholder="Brand"
              name="brand"
              onChange={this.handleChange}
            />
            <br />
            <TextField
              label="Model"
              type="text"
              placeholder="Model"
              name="model"
              onChange={this.handleChange}
            />
            <br />
            <TextField
              label="Color"
              type="text"
              placeholder="Color"
              name="color"
              onChange={this.handleChange}
            />
            <br />
            <TextField
              label="Year"
              type="text"
              placeholder="Year"
              name="year"
              onChange={this.handleChange}
            />
            <br />
            <TextField
              label="Price"
              type="text"
              placeholder="Price"
              name="price"
              onChange={this.handleChange}
            />
            <br />
            <Button
              style={{ margin: "5px" }}
              variant="outlined"
              color="primary"
              onClick={this.handleSubmit}
            >
              Save
            </Button>
            <Button
              style={{ margin: "5px" }}
              variant="outlined"
              color="secondary"
              onClick={this.cancelSubmit}
            >
              Cancel
            </Button>
          </form>
        </SkyLight>

        <div>
          <Button
            variant="raised"
            color="primary"
            style={{ margin: "10px" }}
            onClick={() => this.refs.addDialog.show()}
          >
            New Car
          </Button>
        </div>
      </div>
    );
  }
}

export default AddCar;
