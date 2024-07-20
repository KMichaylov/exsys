import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import RegistrationPage from "./pages/Registration/RegistrationPage.jsx";
import HomePage from "./pages/HomePage/HomePage.jsx";
import ExamSelectionPage from "./pages/ExamSelectionPage/ExamSelectionPage.jsx";

const router = createBrowserRouter([{path: "/", element: <App/>}, {
    path: "/register",
    element: <RegistrationPage/>
}, {path: "/homepage-student", element: <HomePage/>}, {
    path: "/exam-selection", element: <ExamSelectionPage/>
},{path:"/exam-calculus-A" , element: <ExamPage/>}
])

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>,
)
