import axios from "./Axios";

export const getAllTours = async () => {
    const response = await axios.get("/tour/all");
    return response.data;
}