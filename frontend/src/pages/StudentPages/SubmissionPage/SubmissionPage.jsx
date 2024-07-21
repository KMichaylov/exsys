import React from "react";
import {Box, MantineProvider, Text} from "@mantine/core";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";
import getCssVariableValue from "../../../utils/getcsscolor.js";
import "./SubmissionPage.css";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";

function SubmissionPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const dangerButtonColor = getCssVariableValue("--danger-button-color");
    const backgroundColor = getCssVariableValue("--background-color");

    return (
        <MantineProvider>
            <NavigationBar/>
            <Box className="container" style={{backgroundColor: backgroundColor}}>
                <Text className="header">SUBMISSION</Text>
                <Text className="message">
                    You have come to the end of the exam! Are you sure that you want to hand-in your work?
                </Text>
                <div className="button-container">
                    <CustomButton color={dangerButtonColor} buttonText={"Cancel"} className="button"/>
                    <CustomButton color={primaryButtonColor} buttonText={"Submit"} className="button"/>
                </div>
            </Box>
        </MantineProvider>
    );
}

export default SubmissionPage;
