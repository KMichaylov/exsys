import "../../variables.css"
import '../../App.css'
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import Logo from "../../components/Logo/Logo.jsx";
import {MantineProvider, Modal, Button} from '@mantine/core';
import getCssVariableValue from "../../utils/getcsscolor.js";
import CustomForm from "../../components/CustomForm/CustomForm.jsx";
import {registrationConfig} from "../../utils/formConfigurer.js";
import api from "../../api/people.js";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

function RegistrationPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const secondaryButtonColor = getCssVariableValue("--secondary-button-color");
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();
    const [hasError, setError] = useState(false);

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
        }
    ];

    const handleFormSubmit = async (isValid, formValues) => {
        if (isValid) {
            try {
                const response = await api.post("/register", formValues);
                console.log('API response:', response.data);
                navigate(buttonConfig[1].link);
            } catch (err) {
                const error = err.response?.data?.message || err.message;
                console.error('API request failed:', error);
                setErrorMessage(error);
                setError(true);
            }
        } else {
            console.log('Form validation failed');
            setErrorMessage('Form validation failed. Please check your inputs.');
            setError(true);
        }
    };

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                {hasError === true &&
                    <div className="error-message">{errorMessage}</div>}
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

export default RegistrationPage;
