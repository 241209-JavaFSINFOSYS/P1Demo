import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import 'bootstrap/dist/css/bootstrap.css' //NEED THIS IMPORT FOR BOOTSTRAP TO WORK
import { Login } from './Components/LoginRegister/Login'
import { Register } from './Components/LoginRegister/Register'
import { Teams } from './Components/Teams/Teams'

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* empty string or / for path ro render a component at startup */}
          <Route path="" element={<Login/>}/>
          <Route path="register" element={<Register/>}/>
          <Route path="teams" element={<Teams/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
