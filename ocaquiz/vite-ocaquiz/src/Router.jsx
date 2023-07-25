import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Home from './home';
import Question from './Question'
import CreateQuestion from './question/CreateQuestion';

export default function Router() {
    return (
      <>
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/questions' element={<Question />} />
          <Route path='/questionscreated' element={<CreateQuestion />} />
          <Route path='*' element={<h1>Not found</h1>} />
      </Routes>
      </BrowserRouter>
      </>
    );
  }