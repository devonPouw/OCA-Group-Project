import { useState, useEffect } from "react";

export default function Question() {
  const [questions, setQuestion] = useState("");
  const [isClicked, setClicked] = useState(false);

  handleSubmit((createQuestion) => {
    //alert('A list was submitted: ' + this.state.formvalue);
    createQuestion.preventDefault();
    fetch('http://localhost:8080/api/v1/questions/', {
      method: 'POST',
      headers: {
        
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        id: this.state.id,
        text: this.state.text,
      })
    })
    .then(res => res.json())
    .then(data => console.log(data))
    .catch(err => console.log(err))
  })

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/questions")
      .then((response) => response.json())
      .then((actualData) => setQuestion(actualData.text))
      .catch((err) => console.log(`An error has occurred: ${err.message}.`));
  }, []);


  return (
    <div className="w-full h-full">
      {isClicked ? <p> new question: {questions}</p> : <p><button onClick={() => setClicked(true)}>Click me</button></p>}
    
    </div>
  );
}
