import React from "react";
import {Text} from '@mantine/core';

function HeadingText({text, size, color}) {
    return (
        <Text c={color} size={size}>{text}</Text>
    );
}


export default HeadingText