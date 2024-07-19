import "../../variables.css"
import '../../App.css'
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import Logo from "../../components/Logo/Logo.jsx";
import {MantineProvider} from '@mantine/core';
import CustomButton from "../../components/CustomButton/CustomButton.jsx";
import CustomInput from "../../components/CustomInput/CustomInput.jsx";
import getCssVariableValue from "../../utils/getcsscolor.js";
import {Link} from "react-router-dom";

function RegistrationPage() {
    const primaryColor = getCssVariableValue("--primary-color")
    const primaryButtonColor = getCssVariableValue("--primary-button-color")
    const secondaryButtonColor = getCssVariableValue("--secondary-button-color")

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <div className="input-box">
                        <CustomInput label="Full Name" placeholder="Type your full name"/>
                    </div>
                    <div className="input-box">
                        <CustomInput label="Student Number" placeholder="Type your student number"/>
                    </div>
                    <div className="input-box">
                        <CustomInput label="Email" placeholder="Type your email"/>
                    </div>
                    <div className="input-box">
                        <CustomInput label="Password" placeholder="Type your password"/>
                    </div>
                    <div className="input-box">
                        <CustomInput label="Confirm Password" placeholder="Retype your password"/>
                    </div>
                    <div className="button-box">
                        <Link to="/homepage-student"><CustomButton color={primaryButtonColor} isFullWidth={false} buttonText="Create Account"/> </Link>
                        <Link to="/"><CustomButton color={secondaryButtonColor} isFullWidth={false} buttonText="Back"/> </Link>
                    </div>
                </div>
            </div>
        </MantineProvider>
    );
}

export default RegistrationPage
