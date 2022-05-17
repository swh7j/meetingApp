import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Main from './components/Main';
import List from './components/List';
import Boardlist from './components/BoardList';
import Boardwrite from './components/Boardwrite';
import HeaderComponent from './components/Header';
import FooterComponent from './components/Footer';

function App() {

  return (
    <div>
      <Router>
        <HeaderComponent/>
          <div className="container">
             <Switch>
                 <Route path = "/" exact component = {Main}></Route>

                 <Route path = "/List"  component = {List}></Route>
                 <Route path = "/Boardlist"  component = {Boardlist}></Route>
                 <Route path = "/Boardwrite"  component = {Boardwrite}></Route>
             </Switch>

          </div>
          <br></br>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;