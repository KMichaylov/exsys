import React, {useState} from 'react';
import CustomButton from "../CustomButton/CustomButton.jsx";
import CustomPasswordInput from "../CustomPasswordInput/CustomPasswordInput.jsx";
import CustomInput from "../CustomInput/CustomInput.jsx";
import {Link} from "react-router-dom";
import "./CustomForm.css"

function CustomForm({initialValues, onSubmit, fields, buttonConfig}) {
    const [formValues, setFormValues] = useState(initialValues);
    const [errors, setErrors] = useState({});

    /**
     * Event function to reflect changes in the input elements
     * @param name
     * @param value
     */
    const handleChange = (name, value) => {
        setFormValues((prevValues) => ({
            ...prevValues,
            [name]: value,
        }));
    };

    /**
     * Function to validate the form fields
     * @returns true if there are no validation error
     */
    const validate = () => {
        const newErrors = {};
        for (const key in fields) {
            console.log(key)
            const field = fields[key];
            const value = formValues[field.name];
            if (field.validation) {
                const error = field.validation(value, formValues);
                if (error) {
                    newErrors[field.name] = error;
                }
            }
        }
        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    // Function to handle form submission
    const handleSubmit = (event) => {
        event.preventDefault();
        if (validate()) {
            onSubmit(formValues);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            {Object.values(fields).map((field) => (
                <div key={field.name} style={{marginBottom: '1rem'}}>
                    {field.type === 'text' && (
                        <div className="input-box">
                            <CustomInput
                                label={field.label}
                                placeholder={field.placeholder}
                                value={formValues[field.name] || ''}
                                onChange={(event) => handleChange(field.name, event.currentTarget.value)}
                                error={errors[field.name]} // Pass error message
                                required={field.withAsterisk}
                            />
                        </div>
                    )}
                    {field.type === 'password' && (
                        <div className="input-box">
                            <CustomPasswordInput
                                label={field.label}
                                placeholder={field.placeholder}
                                value={formValues[field.name] || ''}
                                onChange={(event) => handleChange(field.name, event.currentTarget.value)}
                                error={errors[field.name]} // Pass error message
                                required={field.withAsterisk}
                            />
                        </div>
                    )}
                </div>
            ))}
            <div className={buttonConfig.size ? 'button-box' : 'two-buttons'}>
                {Object.values(buttonConfig).map(element =>
                    <Link to={element.link}>
                        <CustomButton
                            buttonText={element.buttonText}
                            color={element.buttonColor}
                            isFullWidth={element.buttonIsFullWidth}/>
                    </Link>
                )}
            </div>
        </form>
    );
}

export default CustomForm;
