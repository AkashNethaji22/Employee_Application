import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

const View = () => {
    const {id}=useParams()
    const[data,setdata]=useState(
        {
            id:"",
            name:"",
            role:""
        }
    );

    useEffect(()=>{
        handlechange()
    })
    const handlechange=async()=>{
         const getone= await axios.get(`http://localhost:8081/employee/${id}`)    
          setdata(getone.data)   
          
    }

  return (
    <div>
        <table>
           <thead>
           <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Role</th>
            </tr>
           </thead>
           <tbody>
                      <tr key={data.id}>
                         <td>{data.id}</td>
                         <td>{data.name}</td>
                         <td>{data.role}</td>
                         <td><Link to={"/"}><button>Back</button></Link></td>
                     </tr>
           </tbody>
        </table>
      
    </div>
  )
}

export default View


{/* <form>
<input type='text'
 name="user"
 onChange={handlechange}
 value={data.name}
 />
 <input type='text'
 name="role"
 onChange={handlechange}
 value={data.role}
 />
 <button type='submit'>Submit</button>
 <button>Back</button>
</form> */}