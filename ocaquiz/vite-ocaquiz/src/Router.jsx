import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Home from './home';
import Question from './Question'
import Header from './components/header';

export default function Router() {
    return (
      <>
      <Header />
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/questions' element={<Question />} />
          <Route path='*' element={<h1>Not found</h1>} />
      </Routes>
      </BrowserRouter>
      </>
    );
  }