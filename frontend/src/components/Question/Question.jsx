import {Group, MantineProvider, Space, Stack, Text} from "@mantine/core";
import QuestionPossibleAnswers from "../QuestionPossbileAnswers/QuestionPossibleAnswers.jsx";
import "./Question.css"

// TODO at later iteration implement the subquestion logic
function Question({question, hasSubquestions}) {
    return (<MantineProvider>
        <Group gap="lg">
            <Text fs="italic" size={"sm"}>{`[${question.points} pts]`}</Text>
            <Text>{question.body}</Text>
        </Group>
        <Stack>
            <Space h="xs" />
            <QuestionPossibleAnswers type={question.type} answers={question.possibleAnswers}/>
        </Stack>
    </MantineProvider>);
}

export default Question