import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import RegistrationPage from "./pages/Registration/RegistrationPage.jsx";

const router = createBrowserRouter([{path: "/", element: <App/>}, {path: "/register", element: <RegistrationPage/>}])

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>,
)
