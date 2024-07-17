import {useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './variables.css'
import './App.css'
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import Logo from "./components/Logo/Logo.jsx";

function App() {

    return (
        <>
            <NavigationBar/>
            <Logo/>
        </>
    )
}

export default App
