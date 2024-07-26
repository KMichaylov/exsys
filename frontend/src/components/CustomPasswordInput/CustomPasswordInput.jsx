import {PasswordInput} from '@mantine/core';

function CustomPasswordInput({name, error, label, placeholder, description, onChange, value}) {
    return (<PasswordInput
        name={name}
        size="md"
        radius="md"
        label={label}
        withAsterisk
        error={error}
        description={description}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
    />);
}


export default CustomPasswordInput