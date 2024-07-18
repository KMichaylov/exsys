import {useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './variables.css'
import './App.css'
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import Logo from "./components/Logo/Logo.jsx";
import CustomInput from "./components/CustomInput/CustomInput.jsx";
import {MantineProvider} from '@mantine/core';
import CustomButton from "./components/CustomButton/CustomButton.jsx";
import getCssVariableValue from "./utils/getcsscolor.js";

function App() {
    const primaryColor = getCssVariableValue("--primary-color")
    console.log(primaryColor)
    return (
        <>
            <MantineProvider defaultColorScheme="dark">
                <NavigationBar/>
                <Logo/>
                <div className="wrapper-registration">
                    <div className="input-box">
                        <CustomInput label={"Email"} placeholder={"Type your email"}/>
                    </div>
                    <div className="input-box">
                        <CustomInput label={"Password"} placeholder={"Type your password"}/>
                    </div>
                    <div className="input-box">
                        <CustomButton color={primaryColor}/>
                    </div>
                </div>
            </MantineProvider>
        </>
    )
}

export default App
