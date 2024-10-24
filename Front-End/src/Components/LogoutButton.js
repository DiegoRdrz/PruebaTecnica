import React from 'react';
import { useNavigate } from 'react-router-dom';
import { logout } from '../Services/AuthService'; // Función para eliminar el token del localStorage

const LogoutButton = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    logout(); // Llamar a la función de logout para eliminar el token
    navigate('/'); // Redirigir al login
  };

  return (
    <button onClick={handleLogout} className="logout-button">
      Logout
    </button>
  );
};

export default LogoutButton;
