import { MantineProvider, Radio, Checkbox } from "@mantine/core";

function QuestionPossibleAnswers({ answers, type }) {
    const renderQuestionInput = () => {
        switch (type) {
            case "MULTIPLE_CORRECT":
                return answers.map((answer, index) => (
                    <Checkbox label={answer} />
                ));
            case "SINGLE_CORRECT":
                return answers.map((answer, index) => (
                    <Radio label={answer} />
                ));
            // Uncomment and implement the SHORT_ANSWER case if needed
            // case "OPEN_QUESTION":
            //     return <RichTextForm />;
            default:
                return null; // Return null or some default UI if the type doesn't match
        }
    };

    return (
        <MantineProvider>
            {renderQuestionInput()}
        </MantineProvider>
    );
}

export default QuestionPossibleAnswers;
