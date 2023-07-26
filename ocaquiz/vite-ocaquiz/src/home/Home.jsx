import { MdAssignment, MdAssignmentAdd } from 'react-icons/md'
import { Link } from "react-router-dom";
import Header from '../components/header';

export default function Home() {


  return (
    <>
    <Header />
      <div className='w-full h-full'>
      <div className='flex items-center justify-center text-4xl m-10'>
        <div className='flex flex-col items-center'>
        <Link to="/questions"><MdAssignment /></Link>
        <span className='text-2xl m-3'>List of questions</span>
        </div>
        <div className='flex flex-col items-center'>
        <Link to="/createquestions"><MdAssignmentAdd /></Link>
        <span className='text-2xl m-3'>Add questions</span>
        </div>
        </div>
      </div>
    </>
  )
}