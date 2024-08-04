import {Card, Text, Button, Group} from '@mantine/core';

function TextBox({descriptionText, buttonText, buttonColor, onClick}) {
    return (
        <Card shadow="sm" padding="sm" radius="md" withBorder>
            <Group justify="space-between" mt="md" mb="xs">
                <Text fw={500}>{descriptionText}</Text>
            </Group>
            <Button color={buttonColor} fullWidth mt="md" radius="md" onClick={onClick}>
                {buttonText}
            </Button>
        </Card>
    );
}

export default TextBox