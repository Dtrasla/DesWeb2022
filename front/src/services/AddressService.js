import axios from "./Axios";

export const getAllAddresses = async () => {
    const response = await axios.get("/address/all");
    return response.data;
}