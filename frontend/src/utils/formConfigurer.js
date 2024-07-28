import {isEmail, isNotEmpty, matches} from "@mantine/form";

/**
 * A module configuration used for validation purposes for the registration and login forms.
 */

const validateName = (value) => {
    if (matches(/^[A-Za-z' ]+$/)(value)) {
        return 'This name is invalid, use only letters and apostrophes.';
    }
    if (isNotEmpty()(value)) {
        return 'This field cannot be empty';
    }
    return null;
};

const validateEmail = (value) => {
    if (isEmail('The provided email is invalid, please check for mistakes and try again.')(value)) {
        return 'The provided email is invalid, please check for mistakes and try again.';
    }
    if (isNotEmpty()(value)) {
        return 'This field cannot be empty';
    }
    return null;
};

const validatePassword = (value) => {
    if (matches(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{10,}$/)(value)) {
        return "The password should have at least 10 symbols, including small and big letters, alongside at least 1 number.";
    }
    if (isNotEmpty()(value)) {
        return 'This field cannot be empty';
    }
    return null;
};

const validatePasswordConfirmation = (value, formValues) => {
    if (isNotEmpty()(value)) {
        return 'This field cannot be empty';
    }
    return value === formValues.password ? null : 'The confirmation password does not match the previously typed one.';
};

// Configuration objects
export const registrationConfig = {
    fullName: {
        name: 'fullName',
        type: 'text',
        label: 'Full Name',
        placeholder: 'Please enter your full name',
        withAsterisk: true,
        validation: validateName,
    },
    email: {
        name: 'email',
        type: 'text',
        label: 'Email',
        placeholder: 'Enter your email',
        withAsterisk: true,
        validation: validateEmail,
    },
    password: {
        name: 'password',
        type: 'password',
        label: 'Password',
        placeholder: 'Enter your password',
        withAsterisk: true,
        validation: validatePassword,
    },
    confirmPassword: {
        name: 'confirmPassword',
        type: 'password',
        label: 'Confirm Password',
        placeholder: 'Confirm your password',
        withAsterisk: true,
        validation: validatePasswordConfirmation
    },
};

export const loginConfig = {
    email: {
        name: 'email',
        type: 'text',
        label: 'Email',
        placeholder: 'Enter your email',
        withAsterisk: true,
        validation: validateEmail,
    },
    password: {
        name: 'password',
        type: 'password',
        label: 'Password',
        placeholder: 'Enter your password',
        withAsterisk: true,
        validation: validatePassword,
    },
};
