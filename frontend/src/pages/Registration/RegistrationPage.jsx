import "../../variables.css"
import '../../App.css'
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import Logo from "../../components/Logo/Logo.jsx";
import {MantineProvider} from '@mantine/core';
import getCssVariableValue from "../../utils/getcsscolor.js";
import CustomForm from "../../components/CustomForm/CustomForm.jsx";
import {registrationConfig} from "../../utils/formConfigurer.js";
import api from "../../api/people.js";

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

    const handleFormSubmit = async (isValid, formValues) => {
        if (isValid) {
            console.log('Form submitted with values:', formValues);
            try {
                const response = await api.post("/register", formValues)
                console.log('API response:', response.data);
                navigate(buttonConfig[1].link);
            } catch (err) {
                console.error('API request failed:', err.response?.data || err.message);
            }
        } else {
            console.log('Form validation failed');
        }

    }

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <CustomForm buttonConfig={buttonConfig}
                                initialValues={{email: '', fullName: '', password: '', confirmPassword: ''}}
                                onSubmit={handleFormSubmit}
                                fields={registrationConfig}/>
                </div>
            </div>
        </MantineProvider>
    );
}

export default RegistrationPage
