import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

export const getEntities = (entity) => axios.get(`${API_BASE_URL}/${entity}`);
export const getEntityById = (entity, id) => axios.get(`${API_BASE_URL}/${entity}/${id}`);
export const createEntity = (entity, data) => axios.post(`${API_BASE_URL}/${entity}`, data);
export const updateEntity = (entity, id, data) => axios.put(`${API_BASE_URL}/${entity}/${id}`, data);
export const deleteEntity = (entity, id) => axios.delete(`${API_BASE_URL}/${entity}/${id}`);
