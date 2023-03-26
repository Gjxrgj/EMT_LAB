import React from 'react';
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Mark"} className={"btn btn-outline-success m-1"} onClick={() => props.onMark(props.term.id)}>
                    Mark
                </a>
                {/*<Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>*/}
                <a title={"Edit"} className={"btn btn-info ml-2"} onClick={() => props.onEdit(props.term.id)} href={`/books/edit/${props.term.id}`}>
                    Edit
                </a>
                <a title={"Delete"} className={"btn btn-danger m-1"} onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
            </td>
        </tr>
    );
}
export default bookTerm;