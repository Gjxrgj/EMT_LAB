import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Redirect} from "react-router-dom";
import libraryService from "../repository/libraryRepository";
import Books from "../books/bookList/books";
import Header from "../header/header";
import Categories from "../categories/categories";
import BookAdd from "../books/bookAdd/bookAdd";
import BookEdit from "../books/bookEdit/bookEdit";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/books/add"} exact render={() => <BookAdd
                            categories={this.state.categories}
                            authors={this.state.authors}
                            onAddBook={this.addBook}/>}/>
                        <Route path={"/books/edit/:id"} exact render={() =>
                            <BookEdit categories={this.state.categories}
                                      authors={this.state.authors}
                                      onEditBook={this.editBook}
                                      book={this.state.selectedBook}/>}/>
                        <Route path={["/books", "/"]} exact render={() => <Books
                            books={this.state.books}
                            onEdit={this.getBook}
                            onDelete={this.deleteBook}
                            onMark={this.markBook}/>}/>
                        <Route path={"/categories"} exact render={() => <Categories
                            categories={this.state.categories}/>}/>
                        {/*<Redirect to={"/books"}/>*/}
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    loadBooks = () => {
        libraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }
    loadCategories = () => {
        libraryService.fetchCategories()
            .then((data) => {
                this.setState(
                    {
                        categories: data.data
                    })
            });
    }
    loadAuthors = () => {
        libraryService.fetchAuthors()
            .then((data) => {
                this.setState(
                    {
                        authors: data.data
                    })
            });
    }
    getBook = (id) => {
        libraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }
    deleteBook = (id) => {
        libraryService.deleteBook(id)
            .then(() => {
               this.loadBooks();
            });
    }
    markBook = (id) => {
        libraryService.markBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
    addBook = (name, category, author, availableCopies) => {
        libraryService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
    editBook = (id, name, category, author, availableCopies) => {
        libraryService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
}

export default App;
