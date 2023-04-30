import React from "react";
import {useNavigate} from "react-router-dom";

const BookEdit = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        category:"NOVEL",
        authorId: 1,
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
        const category = formData.category !== "" ? formData.category : props.book.category.toString();
        const authorId = formData.authorId !== 1 ? formData.authorId : props.book.author.id;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;

        props.onEditBook(props.book.id, name, category, authorId, availableCopies);
        navigate('/books')
    }


    return(
        <div className="row mt-5">
            <div className="col-md-5 mx-4">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label>Book name</label>
                        <input type="text"
                               className="form-control"
                               name="name"
                               id="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                                    if(props.book.category !== undefined){
                                        return <option value={term}>{term.toString()}</option>
                                    }
                                    else return <option value={term}>{term.toString()}</option>
                                }
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="authorId" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name} {term.surname}</option>
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary my-3" onClick={onFormSubmit}>Submit</button>
                </form>
            </div>
        </div>

    )
}

export default BookEdit;