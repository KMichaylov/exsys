import {Grid, MantineProvider, Stack, Text} from "@mantine/core";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../../components/HeadingText/HeadingText.jsx";
import React from "react";
import getCssVariableValue from "../../../utils/getcsscolor.js";
import "./ExamPageTeacher.css"
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";


function ExamPageTeacher() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");
    const boxColor = getCssVariableValue("--box-color");
    return (
        <MantineProvider>
            <NavigationBar role={"teacher"}/>
            <div className="text-button-wrapper">
                <HeadingText color={primaryColor} text={"SMITH WILL - TEACHER"} size={"h2"}/>
                <Text size="md">Exam creation</Text>
                <CustomButton color={primaryButtonColor} buttonText={"Create Exam"}/>
            </div>
            <Grid gutter={"md"}>
                <Grid.Col span={6} style={{paddingRight: '5.5rem'}}>
                    <Stack align="stretch" justify="center" gap="md">
                        <HeadingText color={"black"} text={"Graded Exams"} size={"h4"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Databases / Final Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Computer Architecture / Resit Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Set Theory / Final Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Automata / Resit Exam"}/>
                    </Stack>
                </Grid.Col>

                <Grid.Col span={6} style={{paddingRight: '5.5rem'}}>
                    <Stack align="stretch" justify="center" gap="md">
                        <HeadingText color={"black"} text={"Pending Exams"} size={"h4"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Programming / Final Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Calculus A / Resit Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Calculus B / Final Exam"}/>
                        <CustomButton isFullWidth={true} color={primaryButtonColor}
                                      buttonText={"Computer Networks / Resit Exam"}/>
                    </Stack>
                </Grid.Col>
            </Grid>
        </MantineProvider>
    );
}

export default ExamPageTeacher