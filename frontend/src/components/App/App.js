import './App.css';
import React, {Component} from "react";
import libraryService from "../repository/libraryRepository";
import Books from "../books/books";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      books : []
    }
  }

  render() {
    return (
        <div>
          <Books books={this.state.books}/>
        </div>
    );
  }
  loadBooks = () => {
    libraryService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }
  componentDidMount() {
    this.loadBooks();
  }
}

export default App;
