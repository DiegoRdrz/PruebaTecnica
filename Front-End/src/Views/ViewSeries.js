import React, { useState, useEffect } from 'react';
import { fetchSeries } from '../Services/SerieService';
import LogoutButton from '../Components/LogoutButton';
import { useNavigate } from 'react-router-dom';


const ViewSeries = () => {
  const [series, setSeries] = useState([]);
  const navigate = useNavigate();

  const handleRedirectToView = () => {
    navigate('/create');
  };

  useEffect(() => {
    const loadSeries = async () => {
      try {
        const data = await fetchSeries();
        setSeries(data);
      } catch (error) {
        console.error('Error fetching series', error);
      }
    };
    loadSeries();
  }, []);

  return (
    <div className="container">
      <h1>View Series</h1>
      <div className="series-display">
        {series.length > 0 ? (
          series.map((serie, index) => (
            <div key={index} className="series-item">
              <h3>Time: {serie.time}</h3>
              <pre>{serie.sequence}</pre> {/* Mostrar la secuencia en formato de texto */}
            </div>
          ))
        ) : (
          <p>No series found.</p>
        )}
      </div>
      <button onClick={handleRedirectToView} className="redirect-button">
        Regresar
      </button>
      <LogoutButton /> {/* Botón de logout */}
    </div>
  );
};

export default ViewSeries;
