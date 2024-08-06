import {Group, MantineProvider, Text} from "@mantine/core";
import {Form} from "@mantine/form";
import QuestionPossibleAnswers from "../QuestionPossbileAnswers/QuestionPossibleAnswers.jsx";


function Question({question, hasSubquestions}) {
    return (<MantineProvider>
        <Group>
            <Text fs="italic" size={"sm"}>{`[${question.points} pts]`}</Text>
            <Text>{question.body}</Text>
            <QuestionPossibleAnswers type={question.type} answers={question.possibleAnswers}/>
        </Group>
    </MantineProvider>);
}

export default Question