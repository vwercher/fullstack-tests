import config from 'config';
import { fetchWrapper } from '@/_helpers';

const baseUrl = `${config.apiUrl}/persons`;

export const userService = {
    getAll,
    getById,
    create,
    update,
    delete: _delete
};

function getAll() {
    console.log(baseUrl);
    return fetchWrapper.get(baseUrl, {
        credentials: "include"
    });
}

function getById(id) {
    console.log(baseUrl);
    return fetchWrapper.get(`${baseUrl}/${id}`);    
}

function create(params) {
    return fetchWrapper.post(baseUrl, params);
}

function update(id, params) {
    return fetchWrapper.put(`${baseUrl}/${id}`, params);
}

// prefixed with underscored because delete is a reserved word in javascript
function _delete(id) {
    return fetchWrapper.delete(`${baseUrl}/${id}`);
}
