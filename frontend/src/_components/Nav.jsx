import React from 'react';
import { NavLink } from 'react-router-dom';

function Nav() {
    return (
        <nav className="navbar navbar-expand navbar-dark bg-dark">
            <div className="navbar-nav">                
                <NavLink to="/persons" className="nav-item nav-link">Cadastro de Pessoas</NavLink>                
            </div>
        </nav>
    );
}
export { Nav };