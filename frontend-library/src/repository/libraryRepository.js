import axios from '../custom-axios/axios';

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook : (name,category,author,copies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "copies" : copies
        })
    },
    editBook: (id, name, category,author, copies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "copies" : copies
        });
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    markBook : (id) => {
        return axios.post(`/books/mark/${id}`);
    }
}

export default LibraryService;