import { MdAssignment } from 'react-icons/md'
import { Link } from "react-router-dom";
import Header from '../components/header';

export default function Home() {


  return (
    <>
    <Link to="/"><Header /></Link>
      <div>
      <div className='flex flex-col items-center text-4xl m-10'>
        <Link to="/questions"><MdAssignment/></Link>
        <span className='text-2xl m-3'>List of questions</span>
        </div>
      </div>
    </>
  )
}