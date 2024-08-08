import {Container, Group, MantineProvider, Pagination, Space, Title} from "@mantine/core";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";
import {primaryButtonColor, secondaryButtonColor} from "../../../utils/colorsConstants.js";
import Question from "../../../components/Question/Question.jsx";
import "./ExamPage.css"

function ExamPage() {
    const questions = [{
        body: "Find the maximum value.",
        type: "SINGLE_CORRECT",
        points: "2.0",
        possibleAnswers: ["1", "3", "4", "2"],
        hasParentQuestion: "false"
    }, {
        body: "Which cities are in Europe.",
        type: "MULTIPLE_CORRECT",
        points: "3.0",
        possibleAnswers: ["Madrid", "Paris", "Ottawa", "New York"],
        hasParentQuestion: "false"
    }];

    const examTitle = "Mathematics";

    return (
        <MantineProvider>
            <div className="exam-container">
                <Title>{examTitle}</Title>
                <Space h="xl"/>
                <Group justify="space-around">
                    <div>
                        {questions.map((element, index) => (
                            <Question question={element}/>
                        ))}
                        <Pagination total={5} color={primaryButtonColor} radius="xs"/>
                        <div className="button-container-exam-page">
                            <CustomButton isFullWidth={false} buttonText={"Previous"} color={secondaryButtonColor}/>
                            <CustomButton isFullWidth={false} buttonText={"Next"} color={primaryButtonColor}/>
                        </div>
                    </div>
                </Group>
            </div>
        </MantineProvider>
    );
}

export default ExamPage;
