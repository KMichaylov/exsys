import React, {useEffect, useState} from "react";
import {Grid, MantineProvider, Stack, Text} from "@mantine/core";
import NavigationBar from "../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../components/HeadingText/HeadingText.jsx";
import SearchInput from "../../components/SearchInput/SearchInput.jsx";
import TextBox from "../../components/TextBox/TextBox.jsx";
import getCssVariableValue from "../../utils/getcsscolor.js";
import CustomButton from "../../components/CustomButton/CustomButton.jsx";
import "./HomePage.css";
import {useNavigate} from "react-router-dom";
import api from "../../api/people.js";

function HomePage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");
    const boxColor = getCssVariableValue("--box-color");
    const [exams, setExams] = useState([]);
    const [courses, setCourses] = useState([]);
    const navigate = useNavigate();

    const loadData = async () => {
        try {
            const coursesData = (await api.get("/courses")).data;
            const examsData = (await api.get("/exams")).data;
            setExams(examsData);
            setCourses(coursesData);
            console.log(examsData);
            console.log(coursesData);
        } catch (err) {
            console.error('API request failed:', err.response?.data || err.message);
        }
    };

    useEffect(() => {
        loadData();
    }, []);

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
                            {courses.map((element) => (
                                <div key={element.courseId}>
                                    <SearchInput placeholder={"Please enter the course name"} label={"Course Name"}/>
                                    <TextBox
                                        buttonText={"Go To Exam"}
                                        buttonColor={primaryButtonColor}
                                        descriptionText={element.courseName}
                                        onClick={() => navigate("/exam-selection")}
                                    />
                                </div>
                            ))}
                        </Stack>
                    </Grid.Col>
                    <Grid.Col span={6} style={{paddingLeft: '5.5rem'}}>
                        <Stack h={300} align="stretch" justify="center" gap="md">
                            <Text>Graded Exams</Text>
                            {exams.map(element => (
                                element.graded && (
                                    <CustomButton
                                        key={element.examId}
                                        buttonText={`${element.course.courseName} / ${element.type.toUpperCase()}`}
                                        color={primaryButtonColor}
                                    />
                                )
                            ))}
                        </Stack>
                    </Grid.Col>
                </Grid>
            </div>
        </MantineProvider>
    );
}

export default HomePage;
