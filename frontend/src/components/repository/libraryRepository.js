import axios from '../custom-axios/axios';

const libraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    }

}
export default libraryService;