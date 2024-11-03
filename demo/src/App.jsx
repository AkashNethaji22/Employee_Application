import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Employees from './pages/Employees'
import {  Route, Routes } from 'react-router-dom'
import View from './pages/view'
import Error from './pages/Error'
import EditEployee from './pages/EditEployee'

function App() {

  return (
    <> 
     
      <Routes>
        <Route path='/' element={<Employees/>}/>
        <Route path='/View/:id' element={<View/>}/>
        <Route path="/Edit/:id" element={<EditEployee/>}/>
        <Route path='*' element={<Error/>}/>
        </Routes>

    </>
  )
}

export default App
