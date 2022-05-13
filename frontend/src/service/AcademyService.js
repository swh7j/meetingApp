import axios from 'axios';


const ACADEMY_API_BASE_URL = "http://localhost:80/api/list";

class AcademyService {

    getAcademy_list() {
        return axios.get(ACADEMY_API_BASE_URL);
    }
}
export default new AcademyService();