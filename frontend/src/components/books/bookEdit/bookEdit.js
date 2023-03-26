import React, {useEffect} from 'react'
import {useHistory} from "react-router-dom";

const BookEdit = (props) => {
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
            [e.target.name]: e.target.value.trim()
        })
    }
    const onFormSubmit = (e) => {
        e.preventDefault();

        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "" ? formData.category : props.book.category;
        const author = formData.author !== 1 ? formData.author : props.book.author;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;

        props.onEditBook(props.book.id, name, category, author, availableCopies);
        history.push("/books");
    }
    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label><br/>
                        <input type="text" name="name" id="name" required placeholder={props.book.name} onChange={handleChange}/>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label>Categories</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                {
                                    if(props.book.category !== undefined &&
                                        props.book.category === term)
                                        return <option value={term} selected={term}>
                                            {term}
                                        </option>
                                    else return <option value={term}>
                                            {term}
                                        </option>
                                }
                            )}
                        </select>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => {
                                    if (props.book.author !== undefined &&
                                        props.book.author.id === term.id)
                                        return <option value={term.id} selected={term.name + " " + term.surname}>
                                            term.name + " " + term.surname}
                                        </option>
                                    else return <option value={term.id} >
                                            {term.name + " " + term.surname}
                                        </option>
                                }
                            )}
                        </select>
                    </div>
                    <br/>
                    <div className="form-group">
                        <label htmlFor="availableCopies">availableCopies</label><br/>
                        <input type="text" name="availableCopies" id="availableCopies" required placeholder={props.book.availableCopies} onChange={handleChange}/>
                    </div>
                    <br/>
                    <div className="form-group">
                        <button className="btn btn-primary" id="submit" type="submit">
                            Edit book
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}
export default BookEdit;