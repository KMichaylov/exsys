import React, {useState} from 'react';
import CustomButton from "../CustomButton/CustomButton.jsx";
import CustomPasswordInput from "../CustomPasswordInput/CustomPasswordInput.jsx";
import CustomInput from "../CustomInput/CustomInput.jsx";
import "./CustomForm.css";

function CustomForm({initialValues, onSubmit, fields, buttonConfig}) {
    const [formValues, setFormValues] = useState(initialValues);
    const [errors, setErrors] = useState({});

    const handleChange = (name, value) => {
        setFormValues((prevValues) => ({
            ...prevValues,
            [name]: value,
        }));
    };

    const validate = () => {
        const newErrors = {};
        for (const key in fields) {
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

    const handleSubmit = (event) => {
        event.preventDefault();
        if (validate()) {
            onSubmit(true, formValues);
        } else {
            onSubmit(false);
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
                                error={errors[field.name]}
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
                                error={errors[field.name]}
                                required={field.withAsterisk}
                            />
                        </div>
                    )}
                </div>
            ))}
            <div className={buttonConfig.length === 1 ? 'button-box' : 'two-buttons'}>
                {buttonConfig.map((element) => (
                    <CustomButton
                        buttonText={element.buttonText}
                        color={element.buttonColor}
                        isFullWidth={element.buttonIsFullWidth}/>
                ))}
            </div>
        </form>
    );
}

export default CustomForm;
