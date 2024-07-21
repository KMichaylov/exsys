import React from "react";
import {Title} from '@mantine/core';

function HeadingText({text, size, color, ...props}) {
    return (
        <Title align={"center"} c={color} size={size}>{text}</Title>
    );
}


export default HeadingText