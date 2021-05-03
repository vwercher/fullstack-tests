import config from 'config';
import { fetchWrapper } from '@/_helpers';

const baseUrl = `${config.apiUrl}/persons`;

export const userService = {
    getAll,
    getById,
    create,
    update,
    delete: _delete,
    login,
    logout
};

function getAll() {    
    return fetchWrapper.get(baseUrl);
}

function getById(id) {    
    return fetchWrapper.get(`${baseUrl}/${id}`);    
}

function create(params) {
    return fetchWrapper.post(baseUrl, params);
}

function update(id, params) {
    return fetchWrapper.put(`${baseUrl}/${id}`, params);
}

function _delete(id) {
    return fetchWrapper.delete(`${baseUrl}/${id}`);
}

function login(username, password) {
    return fetchWrapper.login(config.apiUrl, username, password);
}

function logout() {
    return fetchWrapper.logout();
}
