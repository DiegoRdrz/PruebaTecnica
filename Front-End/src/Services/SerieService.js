import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1/series';

const getToken = () => localStorage.getItem('token');

export const createSerie = async (time) => {
  const response = await axios.post(`${API_URL}/${time}`, {}, {
    headers: {
      Authorization: `Bearer ${getToken()}`,
    },
  });
  return response.data;
};

export const fetchSeries = async () => {
  const response = await axios.get(API_URL, {
    headers: {
      Authorization: `Bearer ${getToken()}`,
    },
  });
  return response.data;
};
