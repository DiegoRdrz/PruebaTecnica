import React, { useState, useEffect } from 'react';
import RealTimeClock from '../Components/RealTimeClock';
import { createSerie } from '../Services/SerieService';
import LogoutButton from '../Components/LogoutButton';
import { useNavigate } from 'react-router-dom';

const CreateSeries = () => {
  const [currentTime, setCurrentTime] = useState('');
  const [capturedTime, setCapturedTime] = useState('');
  const [fibonacciSeries, setFibonacciSeries] = useState('No series generated yet.'); // Inicializa con mensaje
  const navigate = useNavigate();

  const handleRedirectToView = () => {
    navigate('/view');
  };

  useEffect(() => {
    const interval = setInterval(() => {
      const now = new Date();
      const timeString = now.toLocaleTimeString('en-GB', { hour12: false });
      setCurrentTime(timeString);
    }, 1000);
    return () => clearInterval(interval);
  }, []);

  const handleCaptureTime = async () => {
    setCapturedTime(currentTime);
    try {
      const response = await createSerie(currentTime);
      console.log('Response from API:', response); // Para depurar
      setFibonacciSeries(response.sequence || 'No series generated yet.'); // Actualiza el estado con la serie
      alert('Serie creada exitosamente');
    } catch (error) {
      console.error('Error creando la serie', error);
      alert('Error al crear la serie. Verifica los detalles en la consola.');
    }
  };

  return (
    <div className="container">
      <h1>Create Fibonacci Series</h1>
      <RealTimeClock />
      <button onClick={handleCaptureTime}>Capture Time</button>
      <p>Captured Time: {capturedTime}</p>
      <div className="fibonacci-display" style={{ border: '1px solid #ccc', padding: '10px', marginTop: '10px' }}>
        <h2>Fibonacci Series:</h2>
        <pre>{fibonacciSeries}</pre> {/* Muestra la serie aquí */}
      </div>
      <button onClick={handleRedirectToView} className="redirect-button">
        Ver series
      </button>
      <LogoutButton /> {/* Botón de logout */}
    </div>
  );
};

export default CreateSeries;
