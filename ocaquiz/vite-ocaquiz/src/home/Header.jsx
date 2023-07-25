import { useEffect } from "react";
import { useState } from "react";

export default function Header() {

    const [user, setUser] = useState({id: -1, name: "none"});
    useEffect(()=>{

    })

    async function onLogin(){
        const data = JSON.stringify({name: document.getElementById("username").value, password: document.getElementById("password").value})
        const body = {
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
              },
            body: data
        }
        await getData("http://localhost:8082/api/user/login", body).then(response => {
            console.log(response)
            if(response.status === "Username is required but not given."){
                document.getElementById("ErrorMessage").innerHTML = "Username is not Specified"
            }
            if(response.status === "Password is required but not given."){
                document.getElementById("ErrorMessage").innerHTML = "Password is not Specified"
            }
            if(response.status === "Username or Password is incorrect."){
                document.getElementById("ErrorMessage").innerHTML = "Incorrect Username or Password"
            }
            if(response.status === "OK"){
                document.getElementById("ErrorMessage").innerHTML = "";
                setUser({id: response.ID, name: response.nickname});
            }
    
        });
        
    
    }

    return (     
    <div className="[text-shadow:_0_1px_0_rgb(0_00/_40%)] sticky top-0 z-50 w-full flex justify-evenly gap-[40%] items-center h-24 bg-white text-gray-800 font-bold text-4xl shadow-md border border-gray-200 rounded-b-xl">
        <div>Ka      <span className="text-orange-500 font-sans italic py-8">Hooters</span></div> 
            {user.id === -1 && <div className=" text-lg">
                <input type="text" name="username" size="10" id="username" className=" border border-2 border-neutral-500 m-5"/>
                <input type="password" name="password" size="10" id="password" className=" border border-2 border-neutral-500 m-5"/>
                <button type="button" className="m-5 p-3 text-white bg-orange-500 rounded-lg" onClick={() => onLogin()}>Login</button>
                <div className="absolute right-[340px] top-16 text-red-500" id="ErrorMessage"></div>
            </div>}
            {user.id !== -1 && <div className="flex gap-5 text-3xl items-center">{user.name}<div className=" bg-orange-500 rounded-[50%] w-14 h-14"></div>
                </div>}
    </div>   
        );
}



async function getData(url, content){
   const response = await fetch(url, content);
   return response.json();
}
