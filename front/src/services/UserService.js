import axios from "./Axios";

export const createUser = async (body) => {
    const response = await axios.post("/user/create",{
        "id": "c563e71b-4609-4fa7-bb06-6225f5f0362a",
        "email": body.email,
        "password": body.password,
        "name": body.name,
        "lastName": body.lastName,
        "birthday": body.birthday,
        "gender": body.gender
    });
    return response.data;
}