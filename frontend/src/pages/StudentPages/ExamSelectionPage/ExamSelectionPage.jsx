import getCssVariableValue from "../../../utils/getcsscolor.js";
import { Grid, MantineProvider, Stack, Text } from "@mantine/core";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../../components/HeadingText/HeadingText.jsx";
import SearchInput from "../../../components/SearchInput/SearchInput.jsx";
import TextBox from "../../../components/TextBox/TextBox.jsx";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"; // Use useNavigate hook from react-router-dom
import api from "../../../api/people.js";

function ExamSelectionPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");
    const [exams, setExams] = useState([]);
    const navigate = useNavigate();

    const loadExamsData = async () => {
        try {
            const examsData = (await api.get("/exams")).data;
            setExams(examsData);
            console.log(examsData);
        } catch (err) {
            console.error('API request failed:', err.response?.data || err.message);
        }
    };

    useEffect(() => {
        loadExamsData();
    }, []);

    return (
        <MantineProvider>
            <div className="wrapper-home-page">
                <NavigationBar role={"student"} />
                <div className="text-header-wrapper">
                    <HeadingText color={primaryColor} text={"CALCULUS A"} size={"h2"} />
                </div>
                <Grid gutter="md">
                    <Grid.Col span={6} style={{ paddingRight: '5.5rem' }}>
                        <Stack align="stretch">
                            <Text size={"lg"}>Exams</Text>
                            <SearchInput placeholder={"Please enter the exam name"} label={"Exam Name"} />
                            {exams.map(element => (
                                <TextBox
                                    key={element.examId}
                                    buttonText={"Go To Exam"}
                                    buttonColor={primaryButtonColor}
                                    descriptionText={`${element.courseName} / ${element.type.toUpperCase()} exam ${element.date}`}
                                    onClick={() => navigate("/exam-selection")}
                                />
                            ))}
                        </Stack>
                    </Grid.Col>
                </Grid>
            </div>
        </MantineProvider>
    );
}

export default ExamSelectionPage;
