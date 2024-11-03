import React from 'react'
import { Link } from 'react-router-dom'

const Error = () => {
  return (
    <div>
       <h1> 404 ERROR</h1>
       <Link to={"/"}><h5>Go back to home</h5></Link>
    </div>
  )
}

export default Error