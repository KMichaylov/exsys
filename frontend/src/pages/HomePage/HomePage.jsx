import React from "react";
import {Grid, MantineProvider, Stack} from "@mantine/core";
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../components/HeadingText/HeadingText.jsx";
import {Text} from '@mantine/core';
import SearchInput from "../../components/SearchInput/SearchInput.jsx";
import TextBox from "../../components/TextBox/TextBox.jsx";
import getCssVariableValue from "../../utils/getcsscolor.js";
import CustomButton from "../../components/CustomButton/CustomButton.jsx";
import "./HomePage.css"
import {Link} from "react-router-dom";

function HomePage({}) {
    // TODO: Export those into a separate file!!!
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");
    const boxColor = getCssVariableValue("--box-color");

    return (
        <MantineProvider>
            <div className="wrapper-home-page">
                <NavigationBar role={"student"}/>
                <div className="text-header-wrapper">
                    <HeadingText color={primaryColor} text={"JOHN JOHNSON - STUDENT"} size={"h2"}/>
                </div>
                <Grid gutter="md">
                    <Grid.Col span={6} style={{paddingRight: '5.5rem'}}>
                        <Stack align="stretch">
                            <Text>Courses</Text>
                            <SearchInput placeholder={"Please enter the course name"} label={"Course Name"}/>
                            <Link style={{ textDecoration: 'none' }} to={"/exam-selection"}><TextBox buttonText={"Go To Exam"}
                                                                  buttonColor={primaryButtonColor}
                                                                  descriptionText={"CALCULUS A"}/></Link>
                            <Link style={{ textDecoration: 'none' }} to={"/"}><TextBox buttonText={"Go To Exam"} buttonColor={primaryButtonColor}
                                                    descriptionText={"CALCULUS B"}/></Link>
                            <Link style={{ textDecoration: 'none' }} to={"/"}><TextBox buttonText={"Go To Exam"} buttonColor={primaryButtonColor}
                                                    descriptionText={"Programming Methods"}/></Link>
                        </Stack>
                    </Grid.Col>
                    <Grid.Col span={6} style={{paddingLeft: '5.5rem'}}>
                        <Stack h={300} align="stretch" justify="center" gap="md">
                            <Text>Graded Exams</Text>
                            <CustomButton buttonText={"Programming / Final Exam"} color={primaryButtonColor}/>
                            <CustomButton buttonText={"Calculus A / Resit Exam"} color={primaryButtonColor}/>
                            <CustomButton buttonText={"Calculus B / Final Exam"} color={primaryButtonColor}/>
                        </Stack>
                    </Grid.Col>
                </Grid>
            </div>
        </MantineProvider>
    );
}

export default HomePage;
