import logo from './logo.svg';
import './App.css';
import { React } from 'react';
import { Component } from 'react';
import Home from './components/home';
import {Route, Routes} from 'react-router-dom';
import LogIn from './components/login';
import Register from './components/register';

import ReactDOM from 'react-dom/client'
import CustomerPage from './components/customerPage';
import AdminPage from './components/adminPage';

// function App() {
//   return (
//     <div className="App">
//       <h1>Here</h1>
//     </div>
//   );
// }

//export default App;

class App extends Component {
  state = {  } 
  render() { 
    return (
      <div className="App">
        <div className='content'>
          <Routes>
            <Route path='/login' element={<LogIn/>}></Route> 
            <Route path='/register' element={<Register />}></Route>
            <Route path='/customer/:customerId' element={<CustomerPage/>}></Route> 
            <Route path='/admin/:adminId' element={<AdminPage/>}></Route> 
            <Route path='/' element={<Home />}></Route>
          </Routes>
        </div>
      </div>);
  }
}
 
export default App;
