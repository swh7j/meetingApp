import './App.css';
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Main from './components/Main';
import List from './components/List';
import HeaderComponent from './components/Header';
import FooterComponent from './components/Footer';

function App() {

  return (
    <div>
      <BrowserRouter>
        <HeaderComponent/>
          <div className="container">
             <Routes>
                 <Route path="/" element={<Main />} />
                 <Route path="/List" element={<List />} />
             </Routes>
          </div>
          <br></br>
        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;