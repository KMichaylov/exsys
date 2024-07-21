import getCssVariableValue from "../../../utils/getcsscolor.js";
import {Grid, MantineProvider, Stack, Text} from "@mantine/core";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../../components/HeadingText/HeadingText.jsx";
import SearchInput from "../../../components/SearchInput/SearchInput.jsx";
import TextBox from "../../../components/TextBox/TextBox.jsx";
import React from "react";
import {Link} from "react-router-dom";

function ExamSelectionPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");

    return (
        <MantineProvider>
            <div className="wrapper-home-page">
                <NavigationBar role={"student"}/>
                <div className="text-header-wrapper">
                    <HeadingText color={primaryColor} text={"CALCULUS A"} size={"h2"}/>
                </div>
                <Grid gutter="md">
                    <Grid.Col span={6} style={{paddingRight: '5.5rem'}}>
                        <Stack align="stretch">
                            <Text size={"lg"}>Exams</Text>
                            <SearchInput placeholder={"Please enter the exam name"} label={"Exam Name"}/>
                            <Link style={{textDecoration: 'none'}} to={"/exam-calculus-A"}><TextBox
                                buttonText={"Go To Exam"}
                                buttonColor={primaryButtonColor}
                                descriptionText={"Calculus A / Resit exam \n" +
                                    "15th January 2024 9:00 - 11:00"}/></Link>
                            <Link style={{textDecoration: 'none'}} to={"/"}><TextBox
                                buttonText={"Go To Exam"}
                                buttonColor={primaryButtonColor}
                                descriptionText={"Calculus A / Final exam \n" +
                                    "15th November 2023 9:00 - 11:00"}/></Link>
                            <Link style={{textDecoration: 'none'}} to={"/"}><TextBox
                                buttonText={"Go To Exam"}
                                buttonColor={primaryButtonColor}
                                descriptionText={"Calculus A / Resit exam \n" +
                                    "12th January 2021 9:00 - 11:00"}/></Link>
                            <Link style={{textDecoration: 'none'}} to={"/"}><TextBox
                                buttonText={"Go To Exam"}
                                buttonColor={primaryButtonColor}
                                descriptionText={"Calculus A / Final exam \n" +
                                    "12th November 2022 9:00 - 11:00"}/></Link>
                        </Stack>
                    </Grid.Col>
                </Grid>
            </div>
        </MantineProvider>)
}

export default ExamSelectionPage