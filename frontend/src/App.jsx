import './variables.css';
import './App.css';
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import Logo from "./components/Logo/Logo.jsx";
import {MantineProvider} from '@mantine/core';
import CustomForm from "./components/CustomForm/CustomForm.jsx";
import getCssVariableValue from "./utils/getcsscolor.js";
import {Link, useNavigate} from "react-router-dom";
import '@mantine/core/styles.css';
import {loginConfig} from "./utils/formConfigurer.js";
import axios from "axios";
import api from "./api/people.js";

function App() {
    const primaryColor = getCssVariableValue("--primary-color");
    const navigate = useNavigate();

    const buttonConfig = [{
        buttonText: "Submit",
        buttonColor: primaryColor,
        buttonIsFullWidth: true,
        link: "/homepage-student"
    }]

    const handleFormSubmit = async (isValid, formValues) => {
        if (isValid) {
            try {
                const response = await api.post("/login", formValues)
                console.log('API response:', response.data);
                navigate(buttonConfig[0].link);
            } catch (err) {
                console.error('API request failed:', err.response?.data || err.message);
            }
        } else {
            console.log('Form validation failed');
        }
    };

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <CustomForm
                        fields={loginConfig}
                        onSubmit={handleFormSubmit}
                        buttonConfig={buttonConfig}
                        initialValues={{email: '', password: ''}}
                    />
                    <span>Don't have an account? <Link to="/register">Register here</Link></span>
                </div>
            </div>
        </MantineProvider>
    );
}

export default App;
