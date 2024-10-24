import React, { useState } from 'react';
import { login } from '../Services/AuthService';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const credentials = { email, password };
      const response = await login(credentials);
       
      if (response && response.token) { // Verifica que la respuesta contenga un token
        alert('Login exitoso');
        navigate('/create'); // Redirige a la vista de crear serie
      } else {
        alert('Error en el login. Credenciales inválidas.'); // Mensaje de error
      }
    } catch (error) {
      console.error('Error en el login', error);
      alert('Error en el login. Inténtalo de nuevo.'); // Mensaje de error
    }
  };

  return (
    <div className="container">
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
      <a href="/register">No tienes una cuenta? Registrate aquí</a>
    </div>
  );
};

export default Login;
