import React from 'react';
import {useHistory} from "react-router-dom";

const BookAdd = (props) => {
    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name:"",
        category:"NOVEL",
        author:1,
        availableCopies:0
    })
    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim(),
        } );
    }
    const onFormSubmit = (e) => {
        e.preventDefault();

        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        history.push("/books");
    }
    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label><br/>
                        <input type="text" name="name" id="name" required placeholder="Enter book name" onChange={handleChange}/>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label>Categories</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                            <option value={term}>
                                {term}
                            </option>
                            )}
                        </select>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>
                                    {term.name + " " + term.surname}
                                </option>
                            )}
                        </select>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label htmlFor="availableCopies">availableCopies</label><br/>
                        <input type="text" name="availableCopies" id="availableCopies" required placeholder="Enter book's availableCopies" onChange={handleChange}/>
                    </div>
                    <br/>
                    <div className="form-group">
                        <button className="btn btn-primary" id="submit" type="submit">
                            Add book
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}
export default BookAdd;