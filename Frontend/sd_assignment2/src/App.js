import logo from './logo.svg';
import './App.css';
import LogIn from './components/logIn';

import { Link } from "react-router-dom";

function App() {
  return (
    <div className="App">
      
      <body>
        <div>
          <h1>Food panda</h1>
          <Link to="/login">Log In</Link>
        </div>
      </body>
    </div>
  );
}

export default App;
