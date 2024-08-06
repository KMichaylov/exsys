import { Group, MantineProvider, Pagination, Title } from "@mantine/core";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";
import { primaryButtonColor, secondaryButtonColor } from "../../../utils/colorsConstants.js";
import Question from "../../../components/Question/Question.jsx";

function ExamPage() {
    const questions = [{
        body: "Find the maximum value.",
        type: "SINGLE_CORRECT",
        points: "2.0",
        possibleAnswers: ["1", "3", "4", "2"],
        hasParentQuestion: "false"
    }, {
        body: "Which cities are in Europe",
        type: "MULTIPLE_CORRECT",
        points: "3.0",
        possibleAnswers: ["Madrid", "Paris", "Ottawa", "New York"],
        hasParentQuestion: "false"
    }];

    const examTitle = "Mathematics";

    return (
        <MantineProvider>
            <Title>{examTitle}</Title>
            <Group justify="space-between">
                {questions.map((element, index) => (
                    <div key={index}>
                        <Question question={element} />
                        <CustomButton isFullWidth={true} buttonText={"Previous"} color={secondaryButtonColor} />
                        <CustomButton isFullWidth={true} buttonText={"Next"} color={primaryButtonColor} />
                        <Pagination total={5} color={primaryButtonColor} radius="xs" />
                    </div>
                ))}
            </Group>
        </MantineProvider>
    );
}

export default ExamPage;
