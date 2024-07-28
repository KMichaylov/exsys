import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import RegistrationPage from "./pages/Registration/RegistrationPage.jsx";
import HomePage from "./pages/HomePage/HomePage.jsx";
import ExamSelectionPage from "./pages/StudentPages/ExamSelectionPage/ExamSelectionPage.jsx";
import ExamPage from "./pages/StudentPages/ExamPage/ExamPage.jsx";
import SubmissionPage from "./pages/StudentPages/SubmissionPage/SubmissionPage.jsx";
import ExamPageTeacher from "./pages/TeacherPages/ExamPageTeacher/ExamPageTeacher.jsx";
import StatisticsPage from "./pages/TeacherPages/StatisticsPage/StatisticsPage.jsx";
import ExamGradingPage from "./pages/TeacherPages/ExamGradingPage/ExamGradingPage.jsx";

const router = createBrowserRouter([
    {path: "/", element: <App/>},
    {
        path: "/register",
        element: <RegistrationPage/>,
    },
    {path: "/homepage-student", element: <HomePage/>},
    {
        path: "/exam-selection",
        element: <ExamSelectionPage/>,
    },
    {path: "/exam-calculus-A", element: <ExamPage/>},
    {path: "/submission-page", element: <SubmissionPage/>},
    {
        path: "/exam-page-teacher",
        element: <ExamPageTeacher/>,
    },
    {path: "/submitted-exams", element: <ExamGradingPage/>},
    {path: "/statistics-page", element: <StatisticsPage/>},
]);

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>,
);
