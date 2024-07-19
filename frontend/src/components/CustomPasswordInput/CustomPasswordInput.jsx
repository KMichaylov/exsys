import {PasswordInput} from '@mantine/core';

function CustomPasswordInput({size, label, placeholder, description}) {
    return (<PasswordInput
        size={size}
        radius="md"
        label={label}
        withAsterisk
        description={description}
        placeholder={placeholder}
    />);
}


export default CustomPasswordInput