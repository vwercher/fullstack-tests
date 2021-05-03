import React from 'react';
import {  BrowserRouter as Router, Route, Switch, Redirect, useLocation } from 'react-router-dom';
import { Nav, Alert } from '@/_components';
import { PrivateRoute } from '../_components';
import { Persons } from '@/persons';
import { LoginPage } from '../LoginPage';

function App() {
    const { pathname } = useLocation();  

    return (
        <div className="app-container bg-light">
            <Nav />
            <Alert />
            <div className="container pt-4 pb-4">
                <Router>
                    <Redirect from="/" to="/login"/>
                    <Route path="/login" component={LoginPage} />
                    <PrivateRoute path="/persons" component={Persons} />                    
                </Router>
            </div>
        </div>
    );
}
//<Redirect from="/:url*(/+)" to={pathname.slice(0, -1)} />
//<Redirect from="*" to="/" />
//<Route exact path="/" component={Home} />
export { App }; 