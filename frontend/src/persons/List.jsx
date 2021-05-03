import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import { userService } from '@/_services';

function List({ match }) {
    const { path } = match;
    const [users, setUsers] = useState(null);

    useEffect(() => {
        userService.getAll().then(x => setUsers(x));
    }, []);

    function deleteUser(id) {
        setUsers(users.map(x => {
            if (x.id === id) { x.isDeleting = true; }
            return x;
        }));
        userService.delete(id).then(() => {
            setUsers(users => users.filter(x => x.id !== id));
        });
    }

    return (
        <div>
            <h1>Cadastro de Pessoas</h1>
            <Link to={`${path}/add`} className="btn btn-sm btn-success mb-2">Adicionar</Link>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th style={{ width: '25%' }}>Name</th>
                        <th style={{ width: '10%' }}>Sexo</th>
                        <th style={{ width: '10%' }}>E-mail</th>
                        <th style={{ width: '20%' }}>Data Nascimento</th>
                        <th style={{ width: '10%' }}>Naturalidade</th>
                        <th style={{ width: '10%' }}>Nacionalidade</th>
                        <th style={{ width: '10%' }}>CPF</th>
                        <th style={{ width: '5%' }}></th>
                    </tr>
                </thead>
                <tbody>
                    {users && users.map(user =>
                        <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>{user.gender}</td>
                            <td>{user.email}</td>
                            <td>{user.birthDate}</td>
                            <td>{user.naturalness}</td>
                            <td>{user.nationality}</td>
                            <td>{user.cpf}</td>                            
                            <td style={{ whiteSpace: 'nowrap' }}>
                                <Link to={`${path}/edit/${user.id}`} className="btn btn-sm btn-primary mr-1">Alterar</Link>
                                <button onClick={() => deleteUser(user.id)} className="btn btn-sm btn-danger btn-delete-user" disabled={user.isDeleting}>
                                    {user.isDeleting 
                                        ? <span className="spinner-border spinner-border-sm"></span>
                                        : <span>Excluir</span>
                                    }
                                </button>
                            </td>
                        </tr>
                    )}
                    {!users &&
                        <tr>
                            <td colSpan="4" className="text-center">
                                <div className="spinner-border spinner-border-lg align-center"></div>
                            </td>
                        </tr>
                    }
                    {users && !users.length &&
                        <tr>
                            <td colSpan="8" className="text-center">
                                <div className="p-2">Nenhuma Pessoa para Exibir</div>
                            </td>
                        </tr>
                    }
                </tbody>
            </table>
            <p>
                    <Link to="/login" className="btn btn-sm btn-warning">Logout</Link>
                </p>
        </div>
    );
}

export { List };