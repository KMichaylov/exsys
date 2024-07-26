import './variables.css';
import './App.css';
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import Logo from "./components/Logo/Logo.jsx";
import {MantineProvider} from '@mantine/core';
import CustomForm from "./components/CustomForm/CustomForm.jsx";
import getCssVariableValue from "./utils/getcsscolor.js";
import {Link} from "react-router-dom";
import '@mantine/core/styles.css';
import {loginConfig} from "./utils/formConfigurer.js";

function App() {
    const primaryColor = getCssVariableValue("--primary-color");
    console.log(primaryColor);

    return (
        <MantineProvider>
            <NavigationBar/>
            <Logo/>
            <div className="wrapper">
                <div className="wrapper-registration">
                    <CustomForm
                        link={"/homepage-student"}
                        fields={loginConfig}
                        onSubmit={() => "0"}
                        buttonColor={primaryColor}
                        buttonIsFullWidth={true}
                        initialValues={{email: '', password: ''}}
                    />
                    <span>Don't have an account? <Link to="/register">Register here</Link></span>
                </div>
            </div>
        </MantineProvider>
    );
}

export default App;
