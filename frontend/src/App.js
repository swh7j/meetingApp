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