import './variables.css'
import './App.css'
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import Logo from "./components/Logo/Logo.jsx";
import CustomInput from "./components/CustomInput/CustomInput.jsx";
import {MantineProvider} from '@mantine/core';
import CustomButton from "./components/CustomButton/CustomButton.jsx";
import getCssVariableValue from "./utils/getcsscolor.js";
import {Router, Link} from "react-router-dom";

function App() {
    const primaryColor = getCssVariableValue("--primary-color")
    console.log(primaryColor)
    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <div className="input-box">
                        <CustomInput label="Email" placeholder="Type your email"/>
                    </div>
                    <div className="input-box">
                        <CustomInput label="Password" placeholder="Type your password"/>
                    </div>
                    <div className="button-box">
                        <CustomButton color={primaryColor} isFullWidth={true} buttonText="Login"/>
                    </div>
                    <span>Don't have an account? <Link to="/register">Register here</Link></span>
                </div>
            </div>
        </MantineProvider>
    );
}

export default App
