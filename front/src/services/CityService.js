import axios from "./Axios";

export const getCityID = async (id) => {
    const response = await axios.get("/city/" + id);
    return response.data;
}