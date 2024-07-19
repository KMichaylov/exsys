import React from 'react';
import { Select } from '@mantine/core';

function SearchInput({ label, data = [], placeholder }) {
    return (
        <Select
            label={label}
            placeholder={placeholder}
            data={data}
            searchable
            nothingFound="No options"
        />
    );
}

export default SearchInput;
