import {Input} from "@mantine/core";
import React from 'react';
import './CustomInput.css';

function CustomInput({ label, error, description, placeholder }) {
    return (
        <Input.Wrapper
            className="custom-input"
            size="md"
            radius="md"
            label={label}
            withAsterisk
            description={description}
            error={error}
        >
            <Input className="input-field" size="md" placeholder={placeholder} />
        </Input.Wrapper>
    );
}

export default CustomInput;
