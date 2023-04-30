import axios from '../custom-axios/axios'

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books")
    },

    fetchCategories: () => {
        return axios.get("/categories")
    },

    fetchAuthors: () => {
        return axios.get("/authors")
    },

    deleteBook: (id) => {
        return axios.delete(`/delete/${id}`)
    },

    addBook: (name,category,authorId,availableCopies) => {
        return axios.post("/add",null,{
            params: {
                name,
                category,
                authorId,
                availableCopies
            }
        })
    },

    editBook:(id,name,category,authorId,availableCopies) => {
        return axios.put(`/edit/${id}`,null,{
            params: {
                name,
                category,
                authorId,
                availableCopies
            }
        })
    },

    getBook: (id) => {
        return axios.get(`edit/${id}`);
    },

    markAsTaken: (id) => {
        return axios.put(`/markAsTaken/${id}`);
    }
}

export default LibraryService;