import {MantineProvider} from "@mantine/core";
import {Radio} from "@mantine/core";
import {Checkbox} from "@mantine/core";
import RichTextForm from "../RichTextForm/RichTextForm.jsx";

function QuestionPossibleAnswers({answers, type}) {
    const renderQuestionInput = () => {
        switch (type) {
            case "MULTIPLE_CORRECT":
                return answers.map((answer, index) => (
                    <Checkbox label={answer}/>
                ));
            case "MULTIPLE_CHOICE":
                return answers.map((answer, index) => (
                    <Radio label={answer} name="multipleChoice"/>
                ));
            case "SHORT_ANSWER":
                return <RichTextForm/>;
        }
    };

    return (
        <MantineProvider>
            {renderQuestionInput()}
        </MantineProvider>
    );
}

export default QuestionPossibleAnswers