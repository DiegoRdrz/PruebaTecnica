// src/Serie.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Serie = () => {
  const [series, setSeries] = useState([]);
  const [time, setTime] = useState('');

  const handleGetSeries = async () => {
    try {
      const token = localStorage.getItem('token');
      if (!token) return;
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      const response = await axios.get('/api/v1/serie');
      setSeries(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleCreateSerie = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem('token');
      if (!token) return;
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      const response = await axios.post(`/api/v1/serie/${time}`);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    handleGetSeries();
  }, []);

  return (
    <div>
      <form onSubmit={handleCreateSerie}>
        <input
          type="datetime-local"
          value={time}
          onChange={(e) => setTime(e.target.value)}
          placeholder="Fecha y hora"
        />
        <button type="submit">Crear Serie</button>
      </form>

      <ul>
        {series.map((serie, index) => (
          <li key={index}>{serie}</li>
        ))}
      </ul>
    </div>
  );
};

export default Serie;
