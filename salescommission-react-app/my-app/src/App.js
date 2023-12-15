import './App.css';
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import "./App.css";
import Home from "./routes/Home";
import GetByDate from "./routes/GetByDate";
import UploadFile from './routes/UploadFile';

 function App() {
  return (
    <div className="App">
     <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/getbydate" element={<GetByDate></GetByDate> } />
        <Route path="/uploadfile" element={<UploadFile></UploadFile> } />
      </Routes>
    </Router>
    </div>
  );
}

export default App;
