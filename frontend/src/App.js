import './App.css';
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Main from './components/Main';
import HeaderComponent from './components/Header';
import FooterComponent from './components/Footer';

function App() {
    useEffect(() => {
    fetch('/')
    .then(response => response.text())
    .then(message => {
    setMessage(message);
    });
},[])
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent/>
          <div className="container">
            <Main/>
          </div>
          <br></br>
        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;