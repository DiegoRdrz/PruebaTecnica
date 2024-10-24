import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Views/Login';
import Register from './Views/Register';
import CreateSerie from './Views/CreateSeries';
import ViewSeries from './Views/ViewSeries';
import ProtectedRoute from './Components/ProtectedRoute';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        
        {/* Rutas protegidas */}
        <Route
          path="/create"
          element={
            <ProtectedRoute>
              <CreateSerie />
            </ProtectedRoute>
          }
        />
        <Route
          path="/view"
          element={
            <ProtectedRoute>
              <ViewSeries />
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
