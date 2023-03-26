import React from 'react';

const header = () => {
    return(
        <header>
            <nav >
                <div className="d-flex flex-row d-inline-flex">
                    <a className="navbar-brand d-inline-flex p-2 " href="/books">Library</a>
                </div>
                <div className="d-flex flex-row-reverse d-inline-flex">
                    <a className="navbar-brand d-inline-flex p-2" href="/books">Books</a>
                    <a className="navbar-brand d-inline-flex p-2" href="/categories">Categories</a>
                </div>
            </nav>
        </header>
    );
}
export default header;