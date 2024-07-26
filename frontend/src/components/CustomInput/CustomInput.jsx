import {Input} from "@mantine/core";
import React from 'react';
import './CustomInput.css';

function CustomInput({name, label, error, description, placeholder, onChange, value}) {
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
            <Input className="input-field" size="md" name={name} onChange={onChange} placeholder={placeholder} value={value}/>
        </Input.Wrapper>
    );
}

export default CustomInput;
