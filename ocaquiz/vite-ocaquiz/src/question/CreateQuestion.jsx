import { useState } from "react";
import { Link } from "react-router-dom";
import { BsFillArrowLeftSquareFill } from "react-icons/bs";
import Header from '../components/header';

export default function CreateQuestion() {
  
const [question, setQuestion] = useState({
    questionText: '',
    choice: [{}]
})
const [choice1, setChoice1] = useState({
  description: '',
  isCorrect: false,
  feedback: '',
  question: question.id
})
const [choice2, setChoice2] = useState({
  description: '',
  isCorrect: false,
  feedback: '',
  question: question.id
})

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
    //save choices (with id from result)
    const choiceResult = await fetch("http://localhost:8080/api/v1/question/choice", {
      method: "POST",
      headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(choice1, choice2)
  })
    
    console.log(result);
    console.log(choiceResult);
}

const handleInput = (e) => {
    e.persist();
    setQuestion({...question, [e.target.name]: e.target.value})
    setChoice1({...choice1, [e.target.name]: e.target.value})
    setChoice2({...choice2, [e.target.name]: e.target.value})
  
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

        <div className="flex flex-row">
          <input
            type="text"
            name="questionText"
            value={question.questionText}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type question here"
          />
          </div>
          
          <div className="flex flex-col items-center">
          <div className="flex flex-row items-center">
          <input type="checkbox" name="isCorrect" value={choice1.isCorrect}></input>
          <label
          className="text-sm font-medium leading-6 text-gray-900"
        >
          A
        </label>

          <input
            type="text"
            name="description"
            value={choice1.description}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type choice1 here"
          />
          <input
            type="text"
            name="feedback"
            value={choice1.feedback}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type feedback here"
          />
          </div>
           <div className="flex flex-row items-center">
           <input type="checkbox" name="isCorrect" value={choice2.isCorrect}></input>
          <label
          className="text-sm font-medium leading-6 text-gray-900"
        >
          B
        </label>

        <div className="flex flex-row">
          <input
            type="text"
            name="description"
            value={choice2.description}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type choice2 here"
          />
          <input
            type="text"
            name="feedback"
            value={choice2.feedback}
            onChange={handleInput}
            className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            placeholder="Type feedback here"
          />
          
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
