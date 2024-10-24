import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ children }) => {
  const token = localStorage.getItem('token'); // Verificar si existe el token en localStorage

  // Si no hay token, redirige al login
  if (!token) {
    return <Navigate to="/" replace />;
  }

  // Si hay token, permite acceder a la ruta protegida
  return children;
};

export default ProtectedRoute;
