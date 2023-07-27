import { useState } from "react";

export default function Choice(props){
    
    const [choice, setChoice] = useState({
        description: '',
        isCorrect: false,
        feedback: '',
      })

    const handleInput = (e) => {
        e.persist();
       const newChoice = {...choice, [e.target.name]: e.target.name === "isCorrect" ? e.target.checked : e.target.value}
        setChoice(newChoice)
        props.updateChoice(newChoice)
    }

    return(
        <div>
        <div className="flex flex-row items-center p-0.5">
        <input className="mr-3" type="checkbox" name="isCorrect" onChange={handleInput} checked={choice.isCorrect}></input>
        
        <input
          type="text"
          name="description"
          value={choice.description}
          onChange={handleInput}
          className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-black-400 focus:ring-2 focus:ring-inset focus:ring-orange-400 sm:text-sm sm:leading-6"
          placeholder="Type answer here"
        />
        <input
          type="text"
          name="feedback"
          value={choice.feedback}
          onChange={handleInput}
          className="w-full rounded-md border-0 py-1.5 pl-7 pr-20  text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-black-400 focus:ring-2 focus:ring-inset focus:ring-orange-400 sm:text-sm sm:leading-6"
          placeholder="Type feedback here"
        />
        </div>
    </div>
    )
}