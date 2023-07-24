import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import App from './App';

export default function Router() {
    return (
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<App />} />
          <Route path='*' element={<h1>Not found</h1>} />
      </Routes>
      </BrowserRouter>
    );
  }