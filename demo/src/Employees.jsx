import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
const Employees = () => {
    const[data,setdata]=useState([])
    const[search,setsearch]=useState("")
  useEffect(()=>{
    getallemployee()
  },[])

  const handledelete = async(id)=>{
    try{
        await axios.delete(`http://localhost:8081/employee/${id}`)
        getallemployee()
        
    }
    catch(e){
        console.log(e);
        
    }
  }
    const getallemployee=async()=>{

        try{
            const getall=await axios.get("http://localhost:8081/employees")
            setdata(getall.data);
        }
        catch(e){
            console.log(e);
            
        }    
    }

    const filterdata= ()=>{
       return data.filter((data)=>(
         data.role.toLowerCase().includes(search)
       ))
    }

    const handlechange=(e)=>{
        setsearch(e.target.value)
    }

  return (
    <div className='table'>
      <div>
         <input type='text' style={{margin:"40px",padding:"20px",width:"60%"}} onChange={handlechange}/>
         {/* {filterdata().map((data)=>(
          <ol key={data.id}>
            <li >{data.id}</li> 
            <li>{data.name} </li>
            <li>{data.role}</li>
          </ol>
         ))} */}
      </div>
        <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>NAME</td>
                <td>ROLE</td>
                <td>ACTION</td>
            </tr>
        </thead>
        <tbody>
       
              {
                filterdata().map((data)=>(
                    <tr key={data.id}>
                    <td>{data.id}</td>
                    <td>{data.name}</td>
                    <td>{data.role}</td>
                    <td>
                      <button onClick={()=>handledelete(data.id)}>DELETE</button>
                      <button> <Link to={`/Edit/${data.id}`}>ADDEMPLOYEE</Link></button>
                     <button> <Link to={`/View/${data.id}`}>ViewEmployee</Link></button>
                      </td>

                    </tr>
                ))
              }
        </tbody>
        </table>
    </div>

  )
}
//search
//view
//delete
//edit
export default Employees