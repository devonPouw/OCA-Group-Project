import { useState } from "react";
import { Link } from "react-router-dom";
import { BsFillArrowLeftSquareFill } from "react-icons/bs";
import Header from '../components/header';

export default function CreateQuestion() {
  
const [question, setQuestion] = useState({
    text: ''
})

const saveQuestion = async (e) => {
    e.preventDefault();
    const result = await fetch("http://localhost:8080/api/v1/questions", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(question)
    })
    
    console.log(result);
}

const handleInput = (e) => {
    e.persist();
    setQuestion({...question, [e.target.name]: e.target.value})
}
  
    return (
    <div className="w-full h-full">
        <Link to="/"><Header /></Link>
        <Link to="/questions"><BsFillArrowLeftSquareFill/></Link>
        <div className="flex flex-row justify-center">
        </div>
        <form onSubmit={saveQuestion}>
      <div className="flex flex-col items-center">
        <label
          
          className="text-sm font-medium leading-6 text-gray-900"
        >
          Question
        </label>

        <div className="flex flex-row">
          <div className="pointer-events-none absolute inset-y-0 left-0 flex items-center pl-3">
            <span className="text-gray-500 sm:text-sm"></span>
          </div>
          <input
            type="text"
            name="text"
            value={question.text}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type question here"
          />
          <button type="submit" className="rounded-full bg-orange-400 p-2 ml-2">
            Add
          </button>
        </div>
      </div>
      </form>
    </div>
  );
}
