import axios from '../custom-axios/axios';

const ELibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, authorId, category, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "authorId" : authorId,
            "category" : category,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id, name, authorId, category, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "authorId" : authorId,
            "category" : category,
            "availableCopies" : availableCopies
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
}

export default ELibraryService;