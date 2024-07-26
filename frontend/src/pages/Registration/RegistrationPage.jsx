import "../../variables.css"
import '../../App.css'
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import Logo from "../../components/Logo/Logo.jsx";
import {MantineProvider} from '@mantine/core';
import getCssVariableValue from "../../utils/getcsscolor.js";
import CustomForm from "../../components/CustomForm/CustomForm.jsx";
import {registrationConfig} from "../../utils/formConfigurer.js";

function RegistrationPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color")
    const secondaryButtonColor = getCssVariableValue("--secondary-button-color")


    const buttonConfig = [
        {
            buttonText: "Back",
            buttonColor: secondaryButtonColor,
            buttonIsFullWidth: false,
            link: "/"
        }, {
            buttonText: "Submit",
            buttonColor: primaryButtonColor,
            buttonIsFullWidth: false,
            link: "/homepage-student"
        }]

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <CustomForm buttonConfig={buttonConfig}
                                initialValues={{email: '', fullName: '', password: '', confirmPassword: ''}}
                                onSubmit={() => "0"}
                                fields={registrationConfig}/>
                </div>
            </div>
        </MantineProvider>
    );
}

export default RegistrationPage
