import React from "react";
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return(
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name + ' ' + props.term.author.surname}</td>
            <td>{props.term.avaliableCopies}</td>
            <td className={"text-right"}>
                <Link title={"Delete"} className={"btn btn-danger"}
                      onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </Link>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <Link title={"Mark as Taken"} className={"btn btn-sm btn-primary cart-product"}
                      onClick={() => props.onMark(props.term.id)}>
                    Mark as Taken
                </Link>
            </td>
        </tr>
    )
}

export default bookTerm;