import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div>
            <h1>React - CRUD</h1>
            
            <p><Link to="persons">Gerenciar Pessoas</Link></p>
        </div>
    );
}

export { Home };