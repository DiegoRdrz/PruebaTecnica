import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1/auth/';

export const login = async (credentials) => {
  const response = await axios.post(`${API_URL}signin`, credentials);
  localStorage.setItem('token', response.data.token); 
  return response.data;
};

export const register = async (userData) => {
  const response = await axios.post(`${API_URL}signup`, userData);
  return response.data;
};

export const logout = () => {
  localStorage.removeItem('token');
};
