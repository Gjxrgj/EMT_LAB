import React from "react";
import BookTerm from "../bookTerm/bookTerm";

const books = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Book's name</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>CRUD</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.books.map((term) => {
                            return(
                               <BookTerm term={term} onDelete={props.onDelete} onMark={props.onMark} onEdit={props.onEdit}/>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <a className="btn btn-block btn-dark" href={"/books/add"}>Add book</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default books;