import logo from '../../logo.svg';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import ELibraryService from "../../repository/elibraryRepository";
import Header from '../Header/header';
import Books from '../Books/BooksList/books';
import BookEdit from "../Books/BookEdit/bookEdit";
import './App.css';

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
                 {/*<Route path={"/categories"} exact render={() =>*/}
                 {/*    <Categories categories={this.state.categories}/>}/>*/}
                 {/*<Route path={"/books/add"} exact render={() =>*/}
                 {/*    <BookAdd categories={this.state.books}*/}
                 {/*                authors={this.state.authors}*/}
                 {/*                onAddBook={this.addBook}/>}/>*/}
                <Route path={"/books/edit/:id"} exact render={() =>
                    <BookEdit categories={this.state.categories}
                              authors={this.state.authors}
                              onEditBook={this.editBook}
                              book={this.state.selectedBook}>
                    </BookEdit>}/>
                <Route path={"/books"} exact render={() =>
                    <Books books={this.state.books}
                              onDelete={this.deteleBook}
                              onEdit={this.getBook}/>}/>
                <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadCategories();
    this.loadBooks();
  }

  loadBooks = () => {
    ELibraryService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCategories = () => {
    ELibraryService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  deleteBook = (id) => {
    ELibraryService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (name, authorId, category, availableCopies) => {
    ELibraryService.addBook(name, authorId, category, availableCopies)
        .then(() => {
          this.loadBooks();
        });
  }

  getBook = (id) => {
    ELibraryService.getBook(id)
        .then((data) => {
          this.setState({
            selectedBook: data.data
          })
        })
  }

  editBook = (id, name, authorId, category, availableCopies) => {
    ELibraryService.editBook(id, name, authorId, category, availableCopies)
        .then(() => {
          this.loadBooks();
        });
  }
}

export default App;
