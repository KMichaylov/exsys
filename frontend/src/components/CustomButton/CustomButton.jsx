import {Button} from '@mantine/core';
import React from 'react';
import "./CustomButton.css"

function CustomButton({color, isFullWidth = false, buttonText, onClick}) {
    return (
        <Button
            variant="filled"
            size="md"
            fullWidth={isFullWidth}
            radius="md"
            type="submit"
            color={color}
            className="custom-button"
            onClick={onClick}
        >
            {buttonText}
        </Button>
    );
}

export default CustomButton;
