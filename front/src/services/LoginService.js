import axios from "./Axios";

export const logIn = async (body) => {
    console.log(body)
    const response = await (await axios.post("/user/login", body)).headers("Access-Control-Allow-Origin", "*").then(console.log("response"));
    return response.data;
}