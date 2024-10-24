import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css'; // Opcional, depende si tienes estilos globales
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
