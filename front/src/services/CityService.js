import axios from "./Axios";

export const getCityID = async () => {
    const response = await axios.get("/city/all");
    return response.data;
}