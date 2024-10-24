import React, { useState, useEffect } from 'react';

function RealTimeClock() {
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => {
      setTime(new Date());
    }, 1000); // Actualiza cada segundo

    return () => clearInterval(timer); // Limpia el intervalo cuando el componente se desmonta
  }, []);

  return (
    <div>
      <h2>Current Time:</h2>
      <p>{time.toLocaleTimeString()}</p>
    </div>
  );
}

export default RealTimeClock;