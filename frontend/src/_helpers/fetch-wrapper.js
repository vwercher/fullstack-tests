import { authHeader } from '../_helpers';
export const fetchWrapper = {
    get,
    post,
    put,
    delete: _delete,
    login,
    logout
};

const headers = { 'Content-Type': 'application/json',
                  'Authorization' :  'Basic ' + btoa('admin:admin')};

function get(url) {
    const requestOptions = {
        method: 'GET',
        headers: headers
    };
    return fetch(url, requestOptions).then(handleResponse);
}

function post(url, body) {
    const requestOptions = {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(body)
    };
    return fetch(url, requestOptions).then(handleResponse);
}

function put(url, body) {
    const requestOptions = {
        method: 'PUT',
        headers: headers,
        body: JSON.stringify(body)
    };
    return fetch(url, requestOptions).then(handleResponse);    
}

function _delete(url) {
    const requestOptions = {
        method: 'DELETE',
        headers: headers
    };
    return fetch(url, requestOptions).then(handleResponse);
}

function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        
        if (!response.ok) {
            if (response.status === 401) {                
                logout();                
                //location.reload(true);
            }
            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    });
}

function login(url, username, password) {
    const requestOptions = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json',
                    'Authorization' :  'Basic ' + btoa(username + ':' + password)}        
    };

    return fetch(url + "/persons", requestOptions)
        .then(handleResponse)
        .then(user => {            
            
            if (user) {            
                user.authdata = window.btoa(username + ':' + password);
                localStorage.setItem('user', JSON.stringify(user));
            }

            return user;
        });
}

function logout() {    
    localStorage.removeItem('user');
}