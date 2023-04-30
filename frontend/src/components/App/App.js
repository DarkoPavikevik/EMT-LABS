import './App.css';
import {Component} from "react";
import React from "react";
import Books from "../Books/books";

import {BrowserRouter, Route, Routes} from "react-router-dom";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import BookAdd from "../BookAdd/bookAdd"
import BookEdit from "../BookEdit/bookEdit";
import LibraryService from "../../repository/libraryRepository";
import Authors from "../Authors/authors";


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
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.editBook} onMarkAsTaken={this.markAsTaken}/>}/>
                    <Route path={"/categories"} element={<Categories categories={this.state.categories}/>}/>
                    <Route path={"/authors"} exact element={<Authors authors={this.state.authors}/>}/>
                    <Route path={"/add"} element={<BookAdd authors={this.state.authors} categories={this.state.categories} onAddBook={this.addBook}/>}></Route>
                    <Route path={"/edit/:id"} element={
                        <BookEdit authors={this.state.authors} categories={this.state.categories} onEditBook={this.editBook} book={this.state.selectedBook}/>
                    }></Route>
                </Routes>
            </BrowserRouter>
        );
    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadAuthors = () => {
        LibraryService.fetchAuthors()
            .then((data)=> {
                this.setState({
                    authors: data.data
                })
            });
    }

    deleteBook = (id) => {
        LibraryService.deleteBook(id)
            .then(()=>{
                this.loadBooks();
            })
    }

    addBook = (name,category,authorId,availableCopies) => {
        LibraryService.addBook(name,category,authorId,availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    editBook = (id,name,category,authorId,availableCopies) => {
        LibraryService.editBook(id,name,category,authorId,availableCopies)
            .then(()=>{
                this.loadBooks();
            })
    }

    markAsTaken = (id) => {
        LibraryService.markAsTaken(id)
            .then(()=>{
                this.loadBooks();
            })
    }

    getBook = (id) => {
        LibraryService.getBook(id)
            .then((data)=>{
                this.setState({
                    selectedBook:data.data
                });
            })
    }


    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }
}

export default App;