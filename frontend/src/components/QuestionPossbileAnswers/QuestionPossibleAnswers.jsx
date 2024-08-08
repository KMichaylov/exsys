import {MantineProvider, Radio, Checkbox, Space} from "@mantine/core";

function QuestionPossibleAnswers({answers, type}) {
    const renderQuestionInput = () => {
        switch (type) {
            case "MULTIPLE_CORRECT":
                return answers.map((answer, index) => (
                    <Checkbox label={answer}/>
                ));
            case "SINGLE_CORRECT":
                return answers.map((answer, index) => (
                    <Radio label={answer}/>
                ));
            // case "OPEN_QUESTION":
            //     return <RichTextForm />;
        }
    };

    return (
        <MantineProvider>
            {renderQuestionInput()}
            <Space h="md"/>
        </MantineProvider>
    );
}

export default QuestionPossibleAnswers;
