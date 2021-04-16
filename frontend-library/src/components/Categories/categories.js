import React from "react";

const categories=(props)=>{
    return(
        <div>
        <section className="jumbotron text-center">
            <div className="container">
                <h1 className="jumbotron-heading">Library</h1>
                <h3 className="jumbotron-heading">All Categories</h3>
            </div>
        </section>
    <div className="container mb-4">
        <div className="row">
            <div className="col-12">
                <div className="table-responsive">
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Categories</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.categories.map((term)=>{
                            return(
                                <tr>
                                    <td>{term}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
        </div>
    )
}

export default categories;