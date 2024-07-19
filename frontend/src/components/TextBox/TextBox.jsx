import {Card, Text, Button, Group} from '@mantine/core';

function TextBox({descriptionText, buttonText, buttonColor}) {
    return (
        <Card shadow="sm" padding="md" radius="md" withBorder>
            <Group justify="space-between" mt="md" mb="xs">
                <Text fw={500}>{descriptionText}</Text>
            </Group>

            <Button color={buttonColor} fullWidth mt="md" radius="md">
                {buttonText}
            </Button>
        </Card>
    );
}

export default TextBox