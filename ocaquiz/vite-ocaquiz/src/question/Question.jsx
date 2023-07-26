import { useState, useEffect } from "react";
import Header from '../components/header';

export default function Question() {
  const [questions, setQuestion] = useState([]);
  const [answers, setAnswer] = useState([]);
  const [isClicked, setClicked] = useState(false);

  
  useEffect(() => {
    fetch("http://localhost:8080/api/v1/questions")
      .then((response) => response.json())
      .then((actualData) => setQuestion(actualData))
      fetch("http://localhost:8080/api/v1/question/choice")
      .then((response) => response.json())
      .then((actualData) => setAnswer(actualData))
      .catch((err) => console.log(`An error has occurred: ${err.message}.`));
  }, []);

  console.log(questions, answers)

  return (
    <div className="w-full h-full flex flex-col">
        <Header />
      {isClicked ? (
       <ul>
       {questions.map((question) => (
         <li key={question.id}>{question.questionText}</li>
       ))}
     </ul>
      ) : (
        <div className="flex items-center">
          <button onClick={() => setClicked(true)}>Click me</button>
        </div>
      )}
      <div><ul>
       {answers.map((answer) => (
         <li key={answer.id}>{answer.description}</li>
       ))}
     </ul></div>
    </div>
  );
}
