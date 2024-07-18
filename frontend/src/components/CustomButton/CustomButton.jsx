import {Button} from '@mantine/core';
import React from "react";

function CustomButton({color, isFullWidth}) {
    return <Button variant="filled" color={color} size="md" fullWidth={isFullWidth} radius="md">Button</Button>;

}

export default CustomButton