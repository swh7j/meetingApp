import axios from 'axios';


const BOARD_API_BASE_URL = "http://localhost:80/api/boardList";

class BoardService {

    get_boardlist() {
        return axios.get(BOARD_API_BASE_URL);
    }
}
export default new BoardService();