import { useState } from "react";
import { Link } from "react-router-dom";
import { BsFillArrowLeftSquareFill } from "react-icons/bs";
import Header from '../components/header';
import Choice from "./Choice";

export default function CreateQuestion() {
  
const [question, setQuestion] = useState({
    questionText: '',
    choices: [{}]
})

const updateChoice0 = (choice) => {
  console.log(question.choices)
  setQuestion({...question, choices:[choice, question.choices[1]]})
}
const updateChoice1 = (choice) => {
  console.log(choice)
  setQuestion({...question, choices:[question.choices[0], choice]})
}

const saveQuestion = async (e) => {
    e.preventDefault();
    //save question
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
        <Header />
        <div className="text-4xl p-4 flex">
        <Link to="/"><BsFillArrowLeftSquareFill/></Link>
        </div>
        <div className="flex flex-row justify-center">
        
        <form onSubmit={saveQuestion}>
      <div className="flex flex-col items-center">
        <label
          className="text-sm font-medium leading-6 text-gray-900"
        >
          Question
        </label>

        <div className="flex flex-row p-2">
          <input
            type="text"
            name="questionText"
            value={question.questionText}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-orange-400 sm:text-sm sm:leading-6"
            placeholder="Type question here"
          />
          </div>
          
          <div className="flex flex-col items-center">
          <div className="flex flex-col items-center">
          <div className="flex flex-row items-center">
          <label className="text-sm font-medium leading-6 text-gray-900 mr-2">
        A
          </label>
          <Choice updateChoice = {updateChoice0} />
          </div>
          <div className="flex flex-row items-center">
          <label className="text-sm font-medium leading-6 text-gray-900 mr-2">
        B
          </label>
          <Choice updateChoice = {updateChoice1} />
          </div>
          
        </div>
        <button type="submit" className="rounded-full bg-orange-400 p-2 ml-2">
            Add
          </button>
        </div>
      </div>
      </form>
      </div>
    </div>
  );
}
