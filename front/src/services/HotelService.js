import axios from "./Axios";

export const getAllHotels = async () => {
    const response = await axios.get("/hotel/all");
    return response.data;
}