import {Input} from '@mantine/core';

function CustomInput({label, error, description, placeholder}){
    return(
        <Input.Wrapper size="xs" label={label} withAsterisk description={description} error={error}>
            <Input size="md" placeholder={placeholder} />
        </Input.Wrapper>
    );
}

export default CustomInput