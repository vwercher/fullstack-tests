import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';

import { userService, alertService } from '@/_services';

function AddEdit({ history, match }) {
    const { id } = match.params;
    const isAddMode = !id;
    
    const validationSchema = Yup.object().shape({       
        name: Yup.string().required('Nome é obrigatório.'),
        email: Yup.string().email('Email inválido'),
        birthDate: Yup.string().required('Data Nascimento é obrigatório'),
        cpf: Yup.string().min(11).max(11).required('CPF é obrigatório')
    });

    // functions to build form returned by useForm() hook
    const { register, handleSubmit, reset, setValue, errors, formState } = useForm({
        resolver: yupResolver(validationSchema)
    });

    function onSubmit(data) {
        return isAddMode
            ? createUser(data)
            : updateUser(id, data);
    }

    function createUser(data) {
        return userService.create(data)
            .then(() => {
                alertService.success('User added', { keepAfterRouteChange: true });
                history.push('.');
            })
            .catch(alertService.error);
    }

    function updateUser(id, data) {
        return userService.update(id, data)
            .then(() => {
                alertService.success('User updated', { keepAfterRouteChange: true });
                history.push('..');
            })
            .catch(alertService.error);
    }

    const [user, setUser] = useState({});
    const [showPassword, setShowPassword] = useState(false);

    useEffect(() => {
        if (!isAddMode) {            
            userService.getById(id).then(user => {
                const fields = ['name', 'gender', 'sexo', 'birthDate', 'email', 'naturalness', 'nationality', 'cpf'];
                fields.forEach(field => setValue(field, user[field]));
                setUser(user);
            });
        }
    }, []);

    return (
        <form onSubmit={handleSubmit(onSubmit)} onReset={reset}>
            <h1>{isAddMode ? 'Cadastrar Pessoa' : 'Alterar Pessoa'}</h1>
            <div className="form-row">                
                <div className="form-group col-5">
                    <label>Nome</label>
                    <input name="name" type="text" ref={register} className={`form-control ${errors.name ? 'is-invalid' : ''}`} />
                    <div className="invalid-feedback">{errors.name?.message}</div>
                </div>

                <div className="form-group col">
                    <label>Sexo</label>
                    <select name="gender" ref={register} className={`form-control ${errors.gender ? 'is-invalid' : ''}`}>
                        <option value=""></option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                        <option value="O">Outro</option>                        
                    </select>
                    <div className="invalid-feedback">{errors.gender?.message}</div>
                </div>
                
            </div>
            <div className="form-row">
                <div className="form-group col-5">
                    <label>Data Nascimento</label>
                    <input name="birthDate" type="date" ref={register} className={`form-control ${errors.birthDate ? 'is-invalid' : ''}`} />
                    <div className="invalid-feedback">{errors.birthDate?.message}</div>
                </div>
                
                <div className="form-group col-7">
                    <label>Email</label>
                    <input name="email" type="text" ref={register} className={`form-control ${errors.email ? 'is-invalid' : ''}`} />
                    <div className="invalid-feedback">{errors.email?.message}</div>
                </div>

                <div className="form-group col">
                    <label>Naturalidade</label>
                    <select name="naturalness" ref={register} className={`form-control ${errors.naturalness ? 'is-invalid' : ''}`}>
                        <option value=""></option>
                        <option value="Biguaçu/SC">Biguaçu/SC</option>
                        <option value="Florianópolis/SC">Florianópolis/SC</option>
                        <option value="Palhoça/SC">Palhoça/SC</option>
                        <option value="São José/SC">São José/SC</option>                        
                    </select>
                    <div className="invalid-feedback">{errors.naturalness?.message}</div>
                </div>
                <div className="form-group col">
                    <label>Nacionalidade</label>
                    <select name="nationality" ref={register} className={`form-control ${errors.nationality ? 'is-invalid' : ''}`}>
                        <option value=""></option>                        
                        <option value="Brasileira">Brasileiro</option>                                                
                    </select>
                    <div className="invalid-feedback">{errors.nationality?.message}</div>
                </div>
                <div className="form-group col-7">
                    <label>CPF</label>
                    <input name="cpf" type="number" ref={register} className={`form-control ${errors.cpf ? 'is-invalid' : ''}`} />
                    <div className="invalid-feedback">{errors.cpf?.message}</div>
                </div>
            </div>                        
            <div className="form-group">
                <button type="submit" disabled={formState.isSubmitting} className="btn btn-primary">
                    {formState.isSubmitting && <span className="spinner-border spinner-border-sm mr-1"></span>}
                    Salvar
                </button>
                <Link to={isAddMode ? '.' : '..'} className="btn btn-link">Cancelar</Link>
            </div>
        </form>
    );
}

export { AddEdit };