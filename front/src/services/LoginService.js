import axios from "./Axios";

export const logIn = async (body) => {
    console.log(body)
    const response = await (await axios.post("/user/login", body));
    return response.data;
}